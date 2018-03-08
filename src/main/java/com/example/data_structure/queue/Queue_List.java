package com.example.data_structure.queue;

import com.example.data_structure.exception.ExceptionQueueEmpty;
import com.example.data_structure.exception.ExceptionQueueFull;

public class Queue_List implements Queue {
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