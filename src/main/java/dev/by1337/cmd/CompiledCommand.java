package dev.by1337.cmd;


import java.util.function.Function;

public class CompiledCommand<C> {
    private final ArgumentMap args;
    private final CommandExecutor<C> executor;
    private final String source;

    public CompiledCommand(ArgumentMap args, CommandExecutor<C> executor, String source) {
        this.args = args;
        this.executor = executor;
        this.source = source;
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

    public String getSource() {
        return source;
    }

    public <R> CompiledCommand<R> map(Function<R, C> mapper) {
        return new CompiledCommand<>(args, executor.map(mapper), source);
    }

    @Override
    public String toString() {
        return "CompiledCommand{" +
                "args=" + args +
                ", executor=" + executor +
                '}';
    }
}
