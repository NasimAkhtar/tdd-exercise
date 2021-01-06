package com.nasim.exercise.tdd;

public class SimpleStringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        if (numbers.length() == 1) return Integer.parseInt(numbers);
        return parse(numbers);
    }

    private int parse(String numbers) {
        char firstChar = numbers.charAt(0);
        boolean firstCharIsANumber = isANumber(firstChar);

        String[] numbersArray;

        if(firstCharIsANumber && !numbers.contains("\n")) {
            numbersArray = numbers.split(",");
        } else if (firstCharIsANumber && numbers.contains("\n")) {
            numbers = numbers.replace("\n", ",");
            numbersArray = numbers.split(",");
        } else {
            String[] split = numbers.split("\n");
            String delimiter = split[0];
            numbersArray = split[1].split(delimiter);
        }
        return sum(numbersArray);
    }

    private boolean isANumber(Character firstChar) {
        try {
            Integer.parseInt(firstChar.toString());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int sum(String[] numbersArray) {
        int sum = 0;
        for (String number: numbersArray) {
            sum += Integer.parseInt(number);
        }
        return sum;
    }
}
