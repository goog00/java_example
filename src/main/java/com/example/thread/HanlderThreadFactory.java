package com.example.thread;

import java.util.concurrent.ThreadFactory;

public class HanlderThreadFactory implements ThreadFactory {
    /**
     * Constructs a new {@code Thread}.  Implementations may also initialize
     * priority, name, daemon status, {@code ThreadGroup}, etc.
     *
     * @param r a runnable to be executed by new thread instance
     * @return constructed thread, or {@code null} if the request to
     * create a thread is rejected
     */
    @Override
    public Thread newThread(Runnable r) {
        System.out.println(this + "create new thread");
        Thread thread = new Thread(r);
        System.out.println("created" + thread);
        //设定线程工厂的异常处理器
        thread.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
        System.out.println("eh" + thread.getUncaughtExceptionHandler());
        return null;
    }
}