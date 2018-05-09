package com.example.thread;

/**
 * 第一步：定义符合线程异常处理器规范的“异常处理器”
 */
public class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {
    /**
     * Method invoked when the given thread terminates due to the
     * given uncaught exception.
     * <p>Any exception thrown by this method will be ignored by the
     * Java Virtual Machine.
     *
     * @param t the thread
     * @param e the exception
     */
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("caught    "+e);
        try {
            throw new Exception(e);
        } catch (Exception e1) {
            e1.printStackTrace();
            throw new RuntimeException("333");
        }
    }
}