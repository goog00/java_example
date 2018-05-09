package com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:
 *
 * @author ST
 * @create 2018-04-17 13:19
 */
public class ThreadExceptionTest {

    public static void main(String[] args) {
//        Thread t = new Thread(new ExceptionThread());
//        t.setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
//        t.start();


        try {
            ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
            exec.execute(new ExceptionThread());
        } catch (Exception e) {
            System.out.println("-------------");
            e.printStackTrace();
        }
    }

}