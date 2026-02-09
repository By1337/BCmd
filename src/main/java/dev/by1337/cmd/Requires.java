package dev.by1337.cmd;

import java.util.function.Function;

public interface Requires<C> {
    boolean test(C ctx);

    default <R> Requires<R> map(Function<R, C> mapper) {
        return c -> test(mapper.apply(c));
    }
}
