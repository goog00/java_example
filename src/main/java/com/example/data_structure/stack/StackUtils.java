package com.example.data_structure.stack;

public class StackUtils {

    /**
     * 借助栈进行数组倒置
     * @param a
     * @return
     */
    public static Integer[] reverse(Integer[] a){

        Stack_Array S = new Stack_Array(a.length);
        Integer[] b = new Integer[a.length];
        for(int i = 0;i < a.length; i++){
            S.push(a[i]);//顺序入栈
        }
        for(int i = 0; i < a.length; i++){
            b[i] = (Integer) S.pop();//逆序退栈
        }
        return b;

    }
}