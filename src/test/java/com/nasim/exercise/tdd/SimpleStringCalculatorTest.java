package com.nasim.exercise.tdd;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class SimpleStringCalculatorTest {

    private static SimpleStringCalculator simpleStringCalculator;

    @BeforeClass
    public static void setUp() {
        simpleStringCalculator = new SimpleStringCalculator();
    }

    @Test
    public void add_forEmptyString_returnsZero() {
        int result = simpleStringCalculator.add("");

        assertEquals(0, result);
    }

    @Test
    public void add_forSingleNumber_returnThatNumber() {
        int result = simpleStringCalculator.add("1");

        assertEquals(1, result);
    }

    @Test
    public void add_forTwoNumbers_returnsSum() {
        int result = simpleStringCalculator.add("1,2");

        assertEquals(3, result);
    }

    @Test
    public void add_forMultipleNumbers_returnsSum() {
        int result = simpleStringCalculator.add("1,2,3");

        assertEquals(6, result);
    }

    @Test
    public void add_numbersWithNewLine_returnSum() {
        int result = simpleStringCalculator.add("1\n2,3");

        assertEquals(6, result);
    }

    @Test
    public void add_supportDifferentDelimiters_returnSum() {
        int result = simpleStringCalculator.add(";\n1;2");

        assertEquals(3, result);
    }

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void add_forNegativeNumber_alwaysThrows() {
        exceptionRule.expect(NumberFormatException.class);
        simpleStringCalculator.add("-1");
    }
}
