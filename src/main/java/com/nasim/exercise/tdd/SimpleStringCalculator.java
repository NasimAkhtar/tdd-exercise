package com.nasim.exercise.tdd;

public class SimpleStringCalculator {
    public int add(String numbers) {
        if (numbers.isEmpty()) return 0;
        if (numbers.contains("-")) throw new NumberFormatException("negatives not allowed" + numbers);
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
            numbersArray = parseNewLineDelimiter(numbers);
        } else {
            numbersArray = parseDefaultDelimiter(numbers);
        }
        return sum(numbersArray);
    }

    private String[] parseNewLineDelimiter(String numbers) {
        String[] numbersArray;
        numbers = numbers.replace("\n", ",");
        numbersArray = numbers.split(",");
        return numbersArray;
    }

    private String[] parseDefaultDelimiter(String numbers) {
        String[] split = numbers.split("\n");

        String delimiter = split[0]
                .replace("[", "")
                .replace("]","");

        return split[1]
                .replace(delimiter, ",")
                .split(",");
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
            int value = Integer.parseInt(number);
            if (value <= 1000) sum += value;
        }
        return sum;
    }
}
