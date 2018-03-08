package com.example.java8.streamtolist;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamToListTest {

    @Test
    public void stream_to_list(){
        List<String> collect = Stream.of("a", "b", "c").collect(Collectors.toList());

        System.out.println(collect);
    }

}