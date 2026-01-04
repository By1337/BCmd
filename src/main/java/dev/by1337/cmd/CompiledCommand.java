package dev.by1337.cmd;


public class CompiledCommand<C> {
    private final ArgumentMap args;
    private final CommandExecutor<C> executor;

    public CompiledCommand(ArgumentMap args, CommandExecutor<C> executor) {
        this.args = args;
        this.executor = executor;
    }

    public ArgumentMap getArgs() {
        return args;
    }

    public CommandExecutor<C> getExecutor() {
        return executor;
    }

    public void execute(C ctx) {
        executor.execute(ctx, args);
    }

    @Override
    public String toString() {
        return "CompiledCommand{" +
                "args=" + args +
                ", executor=" + executor +
                '}';
    }
}
