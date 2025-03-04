package com.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        // Array of numbers
        Integer[] numbers = {42, 15, 8, 23, 91, 16}; // Use Integer (not int) for Comparator

        // Sort in descending order using Comparator
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1; // Descending order
            }
        });

        // Print the sorted array
        System.out.println("Sorted array in descending order:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}

