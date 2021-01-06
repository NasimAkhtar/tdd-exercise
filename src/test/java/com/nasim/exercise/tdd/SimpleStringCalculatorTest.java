package com.nasim.exercise.tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleStringCalculatorTest {
    @Test
    public void add_forEmptyString_returnsZero() {
        SimpleStringCalculator simpleStringCalculator = new SimpleStringCalculator();

        int result = simpleStringCalculator.add("");

        assertEquals(0, result);
    }

    @Test
    public void add_forSingleNumber_returnThatNumber() {
        SimpleStringCalculator simpleStringCalculator = new SimpleStringCalculator();

        int result = simpleStringCalculator.add("1");

        assertEquals(1, result);
    }
}
