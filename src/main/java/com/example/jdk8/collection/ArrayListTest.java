package com.example.jdk8.collection;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

public class ArrayListTest {

    ArrayList arrayList = null;

    @Before
    public void init(){
        
        arrayList = new ArrayList(10000);
    }

    @Test
    public void trimToSizeTest(){
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(5);
        System.out.println("trimToSize之前的大小=" + arrayList.size());
        arrayList.trimToSize();
        System.out.println("trimToSize之后的大小=" + arrayList.size());

    }
}