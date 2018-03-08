package com.example.java8.reduce;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BigDecimalSumTest {

    List<BigDecimal> bigDecimalsValues = new ArrayList<>();

    @Before
    public void setUp () {
        bigDecimalsValues.add(new BigDecimal(1));
        bigDecimalsValues.add(new BigDecimal(2));
        bigDecimalsValues.add(new BigDecimal(3));
        bigDecimalsValues.add(new BigDecimal(4));
        bigDecimalsValues.add(new BigDecimal(5));
    }

    @Test
    public void add_big_decimals_java(){

        BigDecimal sumBigdecimal = bigDecimalsValues.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
        System.out.println(sumBigdecimal);
    }

    @Test
    public void add_big_decimals_java8_null(){
        bigDecimalsValues.add(null);

        BigDecimal sumOfBigDecimals = bigDecimalsValues.stream()
                .filter(Objects::nonNull)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        System.out.println(sumOfBigDecimals);
    }
}