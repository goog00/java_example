package com.example.thread.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 描述:
 *
 * @author ST
 * @create 2018-04-17 15:06
 */
public class TestCachedThreadPool {

    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i = 0; i < 100; i++){
            executorService.execute(new TestRunnable());
            System.out.println("*********** a" + i +"********************");
        }
        executorService.shutdown();
    }

}

class TestRunnable implements Runnable{
    public void run(){
        System.out.println(Thread.currentThread().getName() + "线程被调用了。");
    }
}