package dev.by1337.cmd;

import java.util.function.Function;

@FunctionalInterface
public interface CommandExecutor<C> {
    void execute(C ctx, ArgumentMap args);

    default <R> CommandExecutor<R> map(Function<R, C> mapper){
        return (c, a) -> execute(mapper.apply(c), a);
    }
}
