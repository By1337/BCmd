package dev.by1337.cmd.argument;

import dev.by1337.cmd.*;

import java.util.function.Function;
import java.util.function.Supplier;

public class ArgumentCommand<C> extends Argument<C, ArgumentCommand.RunnableCommand<C>> {
    private final Supplier<Command<C>> commandSupplier;

    public ArgumentCommand(String name, Supplier<Command<C>> commandSupplier) {
        super(name);
        this.commandSupplier = commandSupplier;
    }

    @Override
    public void compile(CommandReader reader, ArgumentMap out) throws CommandMsgError {
        String src = readFull(reader);
        CompiledCommand<C> c = commandSupplier.get().compile(new CommandReader(src));
        if (c == null){
            throw new IllegalStateException("Failed to compile command " + src + " full: " + reader.src());
        }
        out.put(name, (RunnableCommand<C>) (ctx, m) -> c.execute(ctx));
    }

    @Override
    public void parse(C ctx, CommandReader reader, ArgumentMap out) throws CommandMsgError {
        String src = readFull(reader);
        out.put(name, (RunnableCommand<C>) (c, m) -> commandSupplier.get().execute(c, m.apply(src)));
    }

    private String readFull(CommandReader reader) {
        String src = reader.src();
        int idx = reader.ridx();
        if (idx >= src.length()) {
            return "";
        }
        reader.ridx(src.length());
        return src.substring(idx);
    }

    @Override
    public void suggest(C ctx, CommandReader reader, SuggestionsList suggestions, ArgumentMap args) throws CommandMsgError {
        SuggestionsList result = commandSupplier.get().suggest(ctx, reader);
        suggestions.setStart(result.start());
        result.forEach(suggestions::suggest);
    }

    public interface RunnableCommand<C> {
        void run(C ctx, Function<String, String> mutator) throws CommandMsgError;
    }
}
