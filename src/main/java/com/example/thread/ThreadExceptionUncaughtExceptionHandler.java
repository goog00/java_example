package com.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 第四步：使用线程工厂创建线程池，并调用其execute方法
 */
public class ThreadExceptionUncaughtExceptionHandler{
    public static void main(String[] args){
        try {
            ExecutorService exec = Executors.newCachedThreadPool(new HandlerThreadFactory());
            exec.execute(new ExceptionThread());
        } catch (Exception e){
            System.out.println("11" + e);
        }

    }
}