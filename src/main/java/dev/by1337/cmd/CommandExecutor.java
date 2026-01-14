package dev.by1337.cmd;

@FunctionalInterface
public interface CommandExecutor<C> {
    void execute(C ctx, ArgumentMap args);
}
