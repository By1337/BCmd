package dev.by1337.cmd;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class Argument<C, T> {
    protected final String name;
    private final List<Requires<C>> requires = new ArrayList<>();

    public Argument(String name) {
        this.name = name;
    }

    public void compile(CommandReader reader, ArgumentMap out) throws CommandMsgError {
        parse(null, reader, out);
    }

    public abstract void parse(C ctx, CommandReader reader, ArgumentMap out) throws CommandMsgError;

    public abstract void suggest(C ctx, CommandReader reader, SuggestionsList suggestions, ArgumentMap args) throws CommandMsgError;

    public boolean compilable() {
        return false;
    }

    public boolean allowAsync() {
        return false;
    }

    public void requires(Requires<C> r) {
        requires.add(r);
    }

    public boolean requires(C ctx) {
        for (Requires<C> r : requires) {
            if (!r.test(ctx)) {
                return false;
            }
        }
        return true;
    }

    public String name() {
        return name;
    }

    public <R> Argument<R, T> map(Function<R, C> mapper) {
        final Argument<C, T> self = this;
        return new Argument<>(name) {
            private final List<Requires<R>> requires = new ArrayList<>();
            @Override
            public void parse(R ctx, CommandReader reader, ArgumentMap out) throws CommandMsgError {
                if (ctx == null) {
                    self.parse(null, reader, out);
                } else {
                    self.parse(mapper.apply(ctx), reader, out);
                }
            }

            @Override
            public void suggest(R ctx, CommandReader reader, SuggestionsList suggestions, ArgumentMap args) throws CommandMsgError {
                if (ctx == null) {
                    self.suggest(null, reader, suggestions, args);
                } else {
                    self.suggest(mapper.apply(ctx), reader, suggestions, args);
                }
            }

            @Override
            public boolean compilable() {
                return self.compilable();
            }

            @Override
            public boolean allowAsync() {
                return self.allowAsync();
            }

            public void requires(Requires<R> r) {
                requires.add(r);
            }

            @Override
            public boolean requires(R ctx) {
                for (Requires<R> r : requires) {
                    if (!r.test(ctx)) {
                        return false;
                    }
                }
                return self.requires(mapper.apply(ctx));
            }
        };
    }
}
