package com.arrays;

public class ReverseIntArray {
    public static int[] reverseIntArray(int[] array) {
        int start = 0, len = array.length - 1;
        int[] reversedArray = new int[array.length];
        for (int i = 0; i <= len; i++) {
            reversedArray[i] = array[len - i];
        }
        return reversedArray;
    }
}
