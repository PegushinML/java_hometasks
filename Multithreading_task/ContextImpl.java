package java.Multithreading_task;

/**
 * Created by Maxim on 12/20/2016.
 */
public class ContextImpl implements Context, Runnable{

    private final Thread[] tasks;
    private final Runnable callback;
    private final Counter counter;
    private volatile int currentThread;
    private volatile boolean finished;

    public ContextImpl(Runnable callback, Runnable... tasks) {
        this.callback = callback;;
        this.counter = new Counter();
        currentThread = 0;
        finished = false;
        this.tasks = new Thread[tasks.length];
        for(int i = 0; i < tasks.length; i++) {
            this.tasks[i] = new Thread(tasks[i]);
        }
    }


    @Override
    public synchronized int getCompletedTaskCount() {
        int i=0;
        for(Thread task : tasks) {
            if(task.getState().equals(Thread.State.TERMINATED)) {
                i++;
            }
        }
        return i - getInterruptedTaskCount() - getFailedTaskCount();
    }

    @Override
    public synchronized int getFailedTaskCount() {
        return counter.getFailedTask();
    }

    @Override
    public synchronized int getInterruptedTaskCount() {
        return counter.getInterruptedTask();
    }

    @Override
    public synchronized void interrupt() {
        for(Thread task : tasks) {
            if(task.getState().equals(Thread.State.NEW)) {
                task.interrupt();
                counter.incrInterrupted();
            }
        }
    }

    @Override
    public synchronized boolean isFinished() {
        return finished;
    }

    /**
     * When an object implementing interface <code>Runnable</code> is used
     * to create a thread, starting the thread causes the object's
     * <code>run</code> method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method <code>run</code> is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public synchronized void run() {
        while(currentThread < tasks.length) {
            launchTask(tasks[currentThread]);
        }
        while(isFinished()) {
            boolean ready = false;
            for (Thread task : tasks) {

            }
        }
        (new Thread(callback)).start();
    }

    private synchronized void launchTask(Thread task) {
            currentThread++;
        task.start();
            task.setUncaughtExceptionHandler((e, t) -> this.counter.incrFailed());
    }

    private class Counter {
        private volatile int failedTask;
        private volatile int interruptedTask;

        public synchronized int getFailedTask() {
            return failedTask;
        }

        public synchronized void incrFailed() {
            failedTask++;
        }

        public synchronized int getInterruptedTask() {
            return interruptedTask;
        }

        public synchronized void incrInterrupted() {
            interruptedTask++;
        }
    }

}
