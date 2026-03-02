package dev.by1337.cmd;

import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public interface Requires<C> {
    boolean test(@NotNull C ctx);

    default <R> Requires<R> map(Function<R, C> mapper) {
        return c -> test(mapper.apply(c));
    }
}
