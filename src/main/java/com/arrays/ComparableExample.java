package com.arrays;

import java.util.Arrays;

class Number implements Comparable<Number> {
    int value;

    // Constructor
    public Number(int value) {
        this.value = value;
    }

    // Sorting logic for descending order
    @Override
    public int compareTo(Number other) {
        return other.value - this.value; // Descending order
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        // Array of Number objects
        Number[] numbers = {
                new Number(42),
                new Number(15),
                new Number(8),
                new Number(23),
                new Number(91),
                new Number(16)
        };

        // Sort the array using Comparable
        Arrays.sort(numbers);

        // Print the sorted array
        System.out.println("Sorted array in descending order:");
        for (Number num : numbers) {
            System.out.print(num.value + " "); // Accessing the value directly
        }
    }
}
