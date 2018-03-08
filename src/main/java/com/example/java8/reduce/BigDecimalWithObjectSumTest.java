package com.example.java8.reduce;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BigDecimalWithObjectSumTest {
    class Car{
        private BigDecimal miles;

        public Car(BigDecimal miles) {
            this.miles = miles;
        }

        public BigDecimal getMiles() {
            return miles;
        }

        public void setMiles(BigDecimal miles) {
            this.miles = miles;
        }
    }

    @Test
    public void add_big_decimals_java8_object(){

        List<Car> vehicles = new ArrayList<>();
        vehicles.add(null);
        vehicles.add(new Car(null));
        vehicles.add(new Car(new BigDecimal(10)));
        vehicles.add(new Car(new BigDecimal(20)));

        BigDecimal sumOfBigDecimals = vehicles.stream().filter(Objects::nonNull)
                .filter(c->c.getMiles() != null)
                .map(Car::getMiles)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
        System.out.println(sumOfBigDecimals);




    }
}