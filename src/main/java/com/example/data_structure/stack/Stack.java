package com.example.data_structure.stack;

import com.example.data_structure.exception.ExceptionStackEmpty;

public interface Stack {
    //返回栈中数据元素
    int getSize();

    //判断栈是否为空
    boolean isEmpty();

    //取栈顶元素（但不删除）
    Object top() throws ExceptionStackEmpty;

    //入栈
    void push(Object ele);

    //出栈
    Object pop() throws ExceptionStackEmpty;

}