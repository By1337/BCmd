package dev.by1337.cmd;

import dev.by1337.cmd.argument.ArgumentCommand;
import dev.by1337.cmd.argument.ArgumentString;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArgumentCommandSuggestionsTest {
    @Test
    void nestedPartialCommandsKeepSuggestionsAndAbsoluteReplacementOffset() {
        var meta = new Command<Void>("meta")
                .sub(new Command<Void>("set"))
                .sub(new Command<Void>("settemp"))
                .sub(new Command<Void>("unset"));
        var user = new Command<Void>("user").sub(meta);
        var root = new Command<Void>("root")
                .argument(new ArgumentString<>("player"))
                .argument(new ArgumentCommand<>("command", () -> user));

        for (String input : List.of("_By1337_ m", "_By1337_ meta ", "_By1337_ meta s", "_By1337_ meta se")) {
            var suggestions = assertDoesNotThrow(() -> root.suggest(null, input));
            assertEquals(input.lastIndexOf(' ') + 1, suggestions.start());
            if (input.endsWith(" m")) {
                assertEquals(List.of("meta"), suggestions.toList());
            } else {
                assertTrue(suggestions.toList().containsAll(List.of("set", "settemp")));
                assertEquals(input.endsWith(" "), suggestions.toList().contains("unset"));
            }
        }
        assertTrue(root.suggest(null, "_By1337_ meta unknown").isEmpty());
    }

    @Test
    void nestedArgumentsCanBeNestedAgain() {
        var leaf = new Command<Void>("leaf").sub(new Command<Void>("set"));
        var middle = new Command<Void>("middle").argument(new ArgumentCommand<>("inner", () -> leaf));
        var root = new Command<Void>("root").argument(new ArgumentCommand<>("outer", () -> middle));
        assertEquals(List.of("set"), root.suggest(null, "s").toList());
    }

    @Test
    void genuinelyUnreadArgumentsStillThrow() {
        var root = new Command<Void>("root").argument(new Argument<Void, String>("broken") {
            @Override
            public void parse(Void ctx, CommandReader reader, ArgumentMap args) {
            }

            @Override
            public void suggest(Void ctx, CommandReader reader, SuggestionsList suggestions, ArgumentMap args) {
            }
        });
        assertThrows(IllegalStateException.class, () -> root.suggest(null, "abc"));
    }
}
