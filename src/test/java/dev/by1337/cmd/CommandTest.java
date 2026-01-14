package dev.by1337.cmd;

import dev.by1337.cmd.argument.ArgumentString;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void run() {
        var ref = new Object() {
            ArgumentMap expected = null;
            boolean runed;
        };
        Command<Void> command = new Command<Void>("root")
                .sub(new Command<Void>("test")
                        .argument(new ArgumentString<>("s"))
                        .argument(new ArgumentString<>("s1"))
                        .executor((v, args) -> {
                            assertEquals(args, ref.expected);
                            ref.runed = true;
                        })
                )
                .sub(new Command<Void>("test2")
                        .sub(new Command<Void>("test3")

                        )
                )
                ;
        command.suggest(null, "test2 te");
        var v = command.compile("test \"12  3\" '555 555'");
        assertNotNull(v);
        ref.expected = v.getArgs();
        assertEquals("12  3", ref.expected.get("s"));
        assertEquals("555 555", ref.expected.get("s1"));
        command.execute(null, "test \"12  3\" '555 555'");
        assertTrue(ref.runed);
    }
}