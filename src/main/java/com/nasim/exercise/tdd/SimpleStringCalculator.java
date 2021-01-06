package com.nasim.exercise.tdd;

public class SimpleStringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        return parse(numbers);
    }

    private int parse(String numbers) {
        String[] numbersArray;
        if (numbers.contains("\\n")) {
            String[] delimiterAndNumbersArray = numbers.split("\\n");
            numbersArray = delimiterAndNumbersArray[1].split(delimiterAndNumbersArray[0]);
        } else {
            numbersArray = numbers.split(",");
        }
        return sum(numbersArray);
    }

    private int sum(String[] numbersArray) {
        int sum = 0;
        for (String number: numbersArray) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
