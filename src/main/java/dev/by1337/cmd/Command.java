package dev.by1337.cmd;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Function;

public class Command<C> {
    private final String name;
    private final Set<String> aliases = new HashSet<>();
    private final Map<String, Command<C>> subCommands = new HashMap<>();
    private final List<Requires<C>> requires = new ArrayList<>();
    private final List<Argument<C, ?>> arguments = new ArrayList<>();
    private @Nullable CommandExecutor<C> executor;
    private boolean allowAsync = true;


    public Command(String name) {
        this.name = name;
    }

    public Command<C> argument(Argument<C, ?> arg) {
        arguments.add(arg);
        if (!arg.allowAsync()) {
            allowAsync = false;
        }
        return this;
    }

    public Command<C> sub(Command<C> c) {
        subCommands.put(c.name(), c);
        if (!c.allowAsync()) {
            allowAsync = false;
        }
        c.aliases().forEach(a -> subCommands.put(a, c));
        return this;
    }

    public Command<C> executor(CommandExecutor<C> executor) {
        this.executor = executor;
        return this;
    }

    public Command<C> alias(String alias) {
        aliases.add(alias);
        return this;
    }

    public Command<C> aliases(String... aliases) {
        Collections.addAll(this.aliases, aliases);
        return this;
    }

    public Command<C> requires(Requires<C> requires) {
        this.requires.add(requires);
        return this;
    }


    public void execute(C ctx, String input) throws CommandMsgError {
        execute(ctx, new CommandReader(input));
    }

    public void execute(C ctx, CommandReader reader) throws CommandMsgError {
        for (Requires<C> require : requires) {
            if (!require.test(ctx)) {
                return;
            }
        }
        if (reader.hasNext()) {
            int idx = reader.ridx();
            String s = reader.readString();
            Command<C> sub = subCommands.get(s);
            if (sub != null) {
                reader.skip();
                sub.execute(ctx, reader);
                return;
            }
            reader.ridx(idx);
        }
        int i = arguments.size();
        ArgumentMap argumentMap = new ArgumentMap(i);
        if (reader.hasNext()) {
            for (int arg = 0; arg < i; arg++) {
                Argument<C, ?> argument = arguments.get(arg);
                if (!argument.requires(ctx)) {
                    break;
                }
                argument.parse(ctx, reader, argumentMap);
                char next = reader.next();
                if (next == '\0') {
                    break;
                }
                if (next != ' ') {
                    throw new IllegalStateException("Argument " + argument + " не дочитал? " + reader.report());
                }
            }
        }
        if (executor != null)
            executor.execute(ctx, argumentMap);
    }

    public @Nullable CompiledCommand<C> compile(String src) throws CommandMsgError {
        return compile(new CommandReader(src));
    }

    public @Nullable CompiledCommand<C> compile(CommandReader reader) throws CommandMsgError {
        if (reader.hasNext()) {
            int idx = reader.ridx();
            String s = reader.readString();
            Command<C> sub = subCommands.get(s);
            if (sub != null) {
                reader.skip();
                return sub.compile(reader);
            }
            reader.ridx(idx);
        }
        if (executor == null) throw new CommandMsgError("No command executor defined");
        int i = arguments.size();
        ArgumentMap argumentMap = new ArgumentMap(i);
        if (reader.hasNext()) {
            for (int arg = 0; arg < i; arg++) {
                Argument<C, ?> argument = arguments.get(arg);
                if (!argument.compilable()) return null;
                argument.compile(reader, argumentMap);
                char next = reader.next();
                if (next == '\0') {
                    break;
                }
                if (next != ' ') {
                    throw new IllegalStateException("Argument " + argument + " не дочитал? " + reader.report());
                }
            }
        }
        return new CompiledCommand<>(argumentMap, executor, reader.src());
    }

    public @Nullable SuggestionsList suggest(C ctx, String input) {
        return suggest(ctx, new CommandReader(input));
    }

    public SuggestionsList suggest(C ctx, CommandReader reader) throws CommandMsgError {
        if (reader.hasNext()) {
            int idx = reader.ridx();
            String s = reader.readString();
            Command<C> sub = subCommands.get(s);
            if (sub != null) {
                reader.skip();
                return sub.suggest(ctx, reader);
            }
            reader.ridx(idx);
        }

        SuggestionsList suggestions = new SuggestionsList(30, reader.src(), Math.min(reader.ridx(), reader.length()));
        String remaining = suggestions.getRemaining();
        for (String sub : subCommands.keySet()) {
            if (remaining.isBlank() || sub.startsWith(remaining)) {
                suggestions.suggest(sub);
            }
        }
        int i = arguments.size();
        ArgumentMap argumentMap = new ArgumentMap(i);
        for (Argument<C, ?> argument : arguments) {
            if (!argument.requires(ctx)) {
                break;
            }
            try {
                argument.suggest(ctx, reader, suggestions, argumentMap);
            } catch (CommandMsgError msg) {
                if (suggestions.isEmpty()) {
                    throw msg;
                }
            }
            char next = reader.next();
            if (next == '\0') {
                break;
            }
            if (next != ' ') {
                throw new IllegalStateException("Argument " + argument + " не дочитал? " + reader.report());
            }
            suggestions.setStart(Math.min(reader.ridx(), reader.length()));
        }
        return suggestions;
    }

    public String name() {
        return name;
    }

    public boolean allowAsync() {
        return allowAsync;
    }

    public Map<String, Command<C>> getSubcommands() {
        return subCommands;
    }

    public List<Argument<C, ?>> arguments() {
        return arguments;
    }

    public Set<String> aliases() {
        return aliases;
    }

    @Contract(pure = true, value = "_ -> new")
    public <R> Command<R> map(Function<R, C> mapper) {
        Command<R> result = new Command<>(name);
        result.aliases.addAll(aliases);
        subCommands.forEach((k, s) -> result.subCommands.put(k, s.map(mapper)));
        requires.forEach(r -> result.requires.add(r.map(mapper)));
        arguments.forEach(a -> result.arguments.add(a.map(mapper)));
        result.executor = executor != null ? executor.map(mapper) : null;
        result.allowAsync = allowAsync;
        return result;
    }

    @Contract(pure = true, value = " -> new")
    public Command<C> copy() {
        Command<C> result = new Command<>(name);
        result.aliases.addAll(aliases);
        result.subCommands.putAll(subCommands);
        result.requires.addAll(requires);
        result.arguments.addAll(arguments);
        result.executor = executor;
        result.allowAsync = allowAsync;
        return result;
    }

    @Contract(pure = true, value = "_ -> new")
    public Command<C> and(Command<C> o) {
        Command<C> result = copy();
        result.aliases.addAll(o.aliases);
        result.subCommands.putAll(o.subCommands);
        result.requires.addAll(o.requires);
        if (result.executor == null) {
            //overlap
            result.arguments.clear();
            result.arguments.addAll(o.arguments);
            result.executor = o.executor;
        }
        if (result.allowAsync) {
            result.allowAsync = o.allowAsync;
        }
        return result;
    }
}
