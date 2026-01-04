package dev.by1337.cmd;

public class CommandMsgError extends RuntimeException {

    public CommandMsgError(String message) {
        super(message);
    }
}
