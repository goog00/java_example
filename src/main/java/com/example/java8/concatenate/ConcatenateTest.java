package com.example.java8.concatenate;

import org.junit.Test;

import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.stream.*;

public class ConcatenateTest {

    @Test
    public void join_stream(){

        Stream<String> one = Stream.of("one", "two");
        Stream<String> two = Stream.of("three","four");
        List<String> stringList = Stream.concat(one, two).collect(Collectors.toList());
        stringList.stream().forEach(e->System.out.println(e));
    }

    @Test
    public void join_intstream(){
        IntStream intStream = IntStream.of(1, 2);
        IntStream intStream1 = IntStream.of(3,4);

         IntStream.concat(intStream, intStream1).forEach(e->System.out.println(e));

    }

    @Test
    public void join_longstreamstream(){
        LongStream longStream1 = LongStream.of(5,6);
        LongStream longStream2 = LongStream.of(7, 8);
        LongStream.concat(longStream1,longStream2).forEach(e->System.out.println(e));
    }

    @Test
    public void join_doublestream_stream(){
        DoubleStream doubleStream1 = DoubleStream.of(9,10);
        DoubleStream doubleStream2 = DoubleStream.of(11,12);
        DoubleStream.concat(doubleStream1,doubleStream2).forEach(e->System.out.println(e));
    }
}