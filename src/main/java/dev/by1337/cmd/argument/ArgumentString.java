package dev.by1337.cmd.argument;

import dev.by1337.cmd.*;
import org.jetbrains.annotations.Nullable;

public class ArgumentString<C> extends Argument<C, String> {
    private final @Nullable String suggest;

    public ArgumentString(String name) {
        super(name);
        suggest = null;
    }

    public ArgumentString(String name, String suggest) {
        super(name);
        this.suggest = suggest;
    }

    @Override
    public void parse(C ctx, CommandReader reader, ArgumentMap out) throws CommandMsgError {
        var s = reader.readString();
        if (s.isEmpty()) return;
        out.put(name, s);
    }

    @Override
    public void suggest(C ctx, CommandReader reader, SuggestionsList suggestions, ArgumentMap args) throws CommandMsgError {
        String s = reader.readString();
        if (s.isEmpty()) return;
        if (suggest != null) {
            suggestions.suggest(suggest);
        }
        suggestions.suggest(s);
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
