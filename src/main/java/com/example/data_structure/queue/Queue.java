package com.example.data_structure.queue;

import com.example.data_structure.exception.ExceptionQueueEmpty;
import com.example.data_structure.exception.ExceptionQueueFull;

public interface Queue {

    public int getSize();

    //判断队列是否为空
    public boolean isEmpty();

    //取队首元素
    public Object front();

    //入队;
    void enqueue(Object obj)throws ExceptionQueueFull;
    //出队
    Object dequeue() throws ExceptionQueueEmpty;








}