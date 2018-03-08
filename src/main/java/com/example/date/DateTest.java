package com.example.date;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;


public class DateTest {

    Logger logger = LoggerFactory.getLogger(DateTest.class);

    @Test
    public void difference_between_two_dates_java8_period(){
        LocalDate sinceGraduation = LocalDate.of(2017, Month.JUNE, 4);
        LocalDate currentDate = LocalDate.now();

        Period betweenDates = Period.between(sinceGraduation, currentDate);

        int diffInDays = betweenDates.getDays();
        int diffInMonths = betweenDates.getMonths();
        int diffInYears = betweenDates.getYears();

        System.out.println(diffInDays);
//        logger.info(diffInDays);
//        logger.info(diffInMonths);
//        logger.info(diffInYears);

//        assertTrue(diffInDays >= anyInt());
//        assertTrue(diffInMonths >= anyInt());
//        assertTrue(diffInYears >= anyInt());
    }

    @Test
    public void difference_between_two_dates_java8_chrono_period(){
        LocalDate sinceGraduation = LocalDate.of(2017, Month.OCTOBER, 4);
        LocalDate currentDate = LocalDate.now();

        long diffInDays = ChronoUnit.DAYS.between(sinceGraduation, currentDate);
        long diffInMonths = ChronoUnit.MONTHS.between(sinceGraduation,
                currentDate);
        long diffInYears = ChronoUnit.YEARS.between(sinceGraduation,
                currentDate);

        System.out.println(diffInDays);
        System.out.println(diffInMonths);
        System.out.println(diffInYears);

    }
}