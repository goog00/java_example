package com.example.data_structure.queue;

import com.example.data_structure.exception.ExceptionQueueEmpty;
import com.example.data_structure.exception.ExceptionQueueFull;

public class Queue_Array implements Queue {
    public static final int CAPACITY = 1000;//数组的默认容量


    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Object front() {
        return null;
    }

    @Override
    public void enqueue(Object obj) throws ExceptionQueueFull {

    }

    @Override
    public Object dequeue() throws ExceptionQueueEmpty {
        return null;
    }
}