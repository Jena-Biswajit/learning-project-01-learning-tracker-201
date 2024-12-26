package com.arrays;

import java.util.Arrays;
public class ArraySortMethods {
    public static void main(String[] args) {
        // Array of numbers
        int[] numbers = {42, 15, 8, 23, 91, 16};

        // Sort the array in ascending order
        Arrays.sort(numbers);

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
