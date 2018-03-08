package com.example.arrays;

import com.google.common.math.DoubleMath;
import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.junit.Test;

import java.util.Arrays;
import java.util.Observable;
import java.util.OptionalDouble;

public class ArraysTest {

    double[] NUMBERS = {1, 24, 45, 62, 85, 8, 91, 3, 5, 56, 9};

    @Test
    public void calculate_average_of_array_java(){
        double total = 0;
        for(double element : NUMBERS){
            total += element;
        }
        double average = total / NUMBERS.length;
        System.out.println(average);
    }


    @Test
    public void calculate_average_of_array_java8(){
        OptionalDouble average = Arrays.stream(NUMBERS).average();
        System.out.println(average.getAsDouble());
    }

    @Test
    public void calculate_average_of_array_guava(){
        double mean = DoubleMath.mean(NUMBERS);
        System.out.println(mean);
    }

    @Test
    public void calculate_average_of_array_apache(){
        Mean mean = new Mean();
        double average = mean.evaluate(NUMBERS);
        System.out.println(average);
    }

    @Test
    public void calculate_average_of_array_rxjava() {

//        Observable<Integer> findAverage = Observable.from(Arrays.asList(1, 2,
//                3, 4));
//        averageInteger(findAverage).subscribe(System.out::println); // 2
    }
}