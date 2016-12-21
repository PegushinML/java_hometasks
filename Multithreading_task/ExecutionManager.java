package java.Multithreading_task;

/**
 * Created by Maxim on 12/20/2016.
 */
public interface ExecutionManager {
    Context execute(Runnable callback, Runnable... tasks);
}

