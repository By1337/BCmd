package dev.by1337.cmd;

import dev.by1337.cmd.argument.ArgumentString;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void run() {
        var ref = new Object() {
            ArgumentMap expected = null;
            boolean runed;
        };
        Command<Object> command = new Command<Object>("root")
                .sub(new Command<Object>("test")
                        .argument(new ArgumentString<>("s"))
                        .argument(new ArgumentString<>("s1"))
                        .executor((v, args) -> {
                            assertEquals(ref.expected, args);
                            ref.runed = true;
                        })
                )
                .sub(new Command<Object>("test2")
                        .sub(new Command<Object>("test3")

                        )
                )
                .sub(new Command<Object>("flatTest").executor(
                        new ArgumentString<>("test"),
                        new ArgumentString<>("test2"),
                        (sender, test, test2) -> {
                            System.out.println(test);
                            System.out.println(test2);
                        })
                );
        assertEquals(List.of(), command.suggest(new Object(), "test2").toList());
        command.suggest(new Object(), "test2 te");
        var v = command.compile("test \"12  3\" '555 555'");
        assertNotNull(v);
        ref.expected = v.getArgs();
        assertEquals("12  3", ref.expected.get("s"));
        assertEquals("555 555", ref.expected.get("s1"));
        command.execute(new Object(), "test \"12  3\" '555 555'");
        command.execute(new Object(), "flatTest '555 555' '344 555'");
        assertTrue(ref.runed);
    }
}