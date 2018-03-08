package com.example.java8.reduce;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;

import static org.junit.Assert.assertEquals;

public class ReduceTest {

    class Precipitation {

        private LocalDate occurrence;
        private double amount;

        public Precipitation(LocalDate occurrence, double amount) {
            this.occurrence = occurrence;
            this.amount = amount;
        }

        public LocalDate getOccurrence() {
            return occurrence;
        }

        public void setOccurrence(LocalDate occurrence) {
            this.occurrence = occurrence;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }
    }

    List<Precipitation> precip;

    @Before
    public void setUp(){
        precip = new ArrayList<>();
        precip.add(new Precipitation(LocalDate.of(2014, Month.JANUARY,7),.25));
        precip.add(new Precipitation(LocalDate.of(2014, Month.FEBRUARY, 9), .10));
        precip.add(new Precipitation(LocalDate.of(2014, Month.FEBRUARY, 15),
                .50));
        precip.add(new Precipitation(LocalDate.of(2014, Month.MARCH, 9), 1.09));
    }

    @Test
    public void sum_elements(){
        double totalPrecipYear = precip.stream().mapToDouble(Precipitation::getAmount).sum();
        assertEquals(1.9399999999999997, totalPrecipYear, 0);

        OptionalDouble totalPrecipYear2 = precip.stream().mapToDouble(Precipitation::getAmount).reduce(Double::sum);
        assertEquals(1.94,totalPrecipYear2.getAsDouble(),0);

        double totalPrecipYear3  = precip.stream().mapToDouble(Precipitation::getAmount).reduce(0,(a,b)->a + b);
        System.out.println(totalPrecipYear3);

    }

    @Test
    public void max_elements(){
        OptionalDouble max = precip.stream().mapToDouble(Precipitation::getAmount).max();
        System.out.println(max.getAsDouble());

        OptionalDouble max2 = precip.stream().mapToDouble(Precipitation::getAmount).reduce(Double::max);
        System.out.println(max2);
    }


}