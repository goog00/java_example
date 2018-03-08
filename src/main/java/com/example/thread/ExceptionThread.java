package com.example.thread;

/**
 * 第三步：我们的任务可能会抛出异常
 * 显示的抛出一个exception
 */
public class ExceptionThread implements Runnable {
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
    public void run() {
        Thread thread = Thread.currentThread();
        System.out.println("run()" + thread);
        System.out.println("eh = " + thread.getUncaughtExceptionHandler());
        throw new RuntimeException();
    }
}