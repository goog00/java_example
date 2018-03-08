package com.example.java8.buildstream;

import org.junit.Test;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BuildStreamTest {

    @Test
    public void stream_from_values(){
        Stream<String> stream = Stream.of("java8","leveluplunch.com","examples","exercises");
        String joined = stream.map(String::trim).collect(Collectors.joining(","));
        System.out.println(joined);
    }

    @Test
    public void empty_stream(){

        Stream<String> emptyStream = Stream.empty();
        long count = emptyStream.count();
        System.out.println(count);
    }

    @Test
    public void stream_from_array(){
        int[] numbers = {1,2,3,4,5,6,7,8,9};
        int sum = Arrays.stream(numbers).sum();
        System.out.println(sum);
    }

    /**
     * Working with files in Java was completely revamped in Java 7 and enhanced in Java 8 to take advantage of the Stream API.
     * The example below shows how to count the number of distinct words in a file by using java.nio.file.Files which contains a useful method Files.
     * line which returns a stream of strings from a specifed file.
     * Breaking it down further, we read the file line by line splitting the words on a space and a period then taking distinct of all of the elements of the single stream produced by the flatMap.
     * @throws IOException
     */
    @Test
    public void stream_from_file() throws IOException {
        long uniqueWords = Files.lines(Paths.get("d://stream.txt"), Charset.defaultCharset()).flatMap(line->Arrays.stream(line.split(","))).distinct().count();
        System.out.println(uniqueWords);
    }

    /**
     * In the example
     */
    @Test
    public void stream_from_function(){
        Stream.iterate(0,n->n+3).limit(10).forEach(System.out::println);
    }

}