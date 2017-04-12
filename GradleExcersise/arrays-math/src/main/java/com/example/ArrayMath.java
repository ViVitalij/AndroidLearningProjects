package com.example;

public class ArrayMath {

    public static int max(int[] array) {
        if (array.length == 0) {
            throw new IllegalArgumentException("array length equals 0");
        }
        int maxValue = array[0];
        for (int i = 1; i < array.length ; i++) {
            if (maxValue < array[i]) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }
}
