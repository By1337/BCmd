package dev.by1337.cmd;

import java.util.ArrayList;
import java.util.List;

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
}
