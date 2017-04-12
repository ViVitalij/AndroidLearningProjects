package com.losK.numberlistview;

import java.util.List;

public class Statistics {

    public static double mean(List<Integer> numbers) {
        double sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum / numbers.size();
    }

    public static int max(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List can't be empty!");
        }
        int maxValue = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (maxValue < numbers.get(i)) {
                maxValue = numbers.get(i);
            }
        }
        return maxValue;
    }

    public static int min(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("List can't be empty!");
        }
        int minValue = numbers.get(0);

        for (int i = 1; i < numbers.size(); i++) {
            if (minValue > numbers.get(i)) {
                minValue = numbers.get(i);
            }
        }
        return minValue;
    }
}
