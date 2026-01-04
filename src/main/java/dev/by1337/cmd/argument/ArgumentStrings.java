package dev.by1337.cmd.argument;

import dev.by1337.cmd.*;

public class ArgumentStrings<C> extends Argument<C, String> {
    public ArgumentStrings(String name) {
        super(name);
    }

    @Override
    public void parse(C ctx, CommandReader reader, ArgumentMap out) throws CommandMsgError {
        String src = reader.src();
        int idx = reader.ridx();
        if (idx >= src.length()) {
            return;
        }
        out.put(name, src.substring(idx));
        reader.ridx(src.length());
    }

    @Override
    public void suggest(C ctx, CommandReader reader, SuggestionsList suggestions, ArgumentMap args) throws CommandMsgError {
        reader.ridx(reader.length());
    }
    @Override
    public boolean compilable() {
        return true;
    }

    @Override
    public boolean allowAsync() {
        return true;
    }
}
