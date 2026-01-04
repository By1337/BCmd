package dev.by1337.cmd;

public interface Requires<C> {
    boolean test(C ctx);
}
