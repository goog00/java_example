package com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadException implements Runnable {
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
        throw new RuntimeException();
    }

    public static void main(String[] args) {
        try{
            ExecutorService exec = Executors.newCachedThreadPool();
            exec.execute(new ThreadException());
        } catch (RuntimeException e){
            System.out.println("Exception has been handled");
        }

    }
}