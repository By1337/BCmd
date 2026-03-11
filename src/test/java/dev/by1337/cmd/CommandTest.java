package dev.by1337.cmd;

import dev.by1337.cmd.argument.ArgumentString;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CommandTest {

    @Test
    void run2() {
        CommandReader reader = new CommandReader("'1' '2' '3'");

        ArgumentMap argumentMap = new ArgumentMap(3);
        ArgumentString<Void> s = new ArgumentString<>("v1");
        ArgumentString<Void> s1 = new ArgumentString<>("v2");
        ArgumentString<Void> s2 = new ArgumentString<>("v3");

        s.parse(null, reader, argumentMap);
        reader.next();
        s1.parse(null, reader, argumentMap);
        reader.next();
        s2.parse(null, reader, argumentMap);

        System.out.println(argumentMap.toPrettyString());
    }
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
                            assertEquals(ref.expected, args);
                            ref.runed = true;
                        })
                )
                .sub(new Command<Void>("test2")
                        .sub(new Command<Void>("test3")

                        )
                )
                .sub(new Command<Void>("flatTest").executor(
                        new ArgumentString<>("test"),
                        new ArgumentString<>("test2"),
                        (sender, test, test2) -> {
                            System.out.println(test);
                            System.out.println(test2);
                        })
                );
        assertEquals(List.of(), command.suggest(null, "test2").toList());
        command.suggest(null, "test2 te");
        var v = command.compile("test \"12  3\" '555 555'");
        assertNotNull(v);
        ref.expected = v.getArgs();
        assertEquals("12  3", ref.expected.get("s"));
        assertEquals("555 555", ref.expected.get("s1"));
        command.execute(null, "test \"12  3\" '555 555'");
        command.execute(null, "flatTest '555 555' '344 555'");
        assertTrue(ref.runed);
    }
}