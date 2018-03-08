package com.example.data_structure.stack;

import com.example.data_structure.exception.ExceptionStackEmpty;
import com.example.data_structure.exception.ExceptionStackFull;

public class Stack_Array implements Stack {
    public static final int CAPACITY = 1024;//数组的默认变量

    protected int capacity;//数组的实际容量

    protected Object[] S;//对象数组

    protected int top = -1;//栈顶元素的位置

    /**
     * 按照指定容量创建栈对象
     */
    public Stack_Array() {
        this(CAPACITY);
    }

    /**
     * 按照指定容量创建栈对象
     */
    public Stack_Array(int cap){
        capacity = cap;
        S = new Object[capacity];
    }

    /**
     * 获取当前栈的规模
     * @return
     */
    @Override
    public int getSize() {
        return top + 1;
    }

    /**
     * 测试栈是否为空
     * @return
     */
    @Override
    public boolean isEmpty() {
        return top < 0;
    }

    /**
     * 取出栈顶元素
     * @return
     * @throws ExceptionStackEmpty
     */
    @Override
    public Object top() throws ExceptionStackEmpty {
        if(isEmpty()){
            throw new ExceptionStackEmpty("栈空");
        }
        return S[top];
    }

    /**
     * 入栈
     * @param ele
     */
    @Override
    public void push(Object ele) {
        if(getSize() == capacity){
            throw new ExceptionStackFull("意外：栈溢出");
        }
        S[++top] = ele;
    }

    /**
     * 出栈
     * @throws ExceptionStackEmpty
     */
    @Override
    public Object pop() throws ExceptionStackEmpty {

        Object elem;
        if(isEmpty()){
            throw new ExceptionStackEmpty("栈空");
        }
        elem = S[top];
        S[top--] = null;
        return elem;
    }
}