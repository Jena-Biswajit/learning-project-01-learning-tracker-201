package com.arrays;

import java.util.Arrays;

public class MaximizeMinimumDifference {
    public static void main(String[] args) {
        int[] array = {3, 4, 5, 6, 7};
        int k = 2;
        int len = array.length;

        int smallest = Integer.MAX_VALUE; // Initialize to a large value
        int largest = Integer.MIN_VALUE;  // Initialize to a small value

        // Modify the array and find min/max in a single loop
        for (int i = 0; i < len; i++) {
            array[i] = (array[i] > k) ? array[i] - k : array[i] + k;

            // Update smallest and largest values dynamically
            if (array[i] < smallest) {
                smallest = array[i];
            }
            if (array[i] > largest) {
                largest = array[i];
            }
        }

        System.out.println("Modified array: " + java.util.Arrays.toString(array));
        System.out.println("Largest element: " + largest);
        System.out.println("Smallest element: " + smallest);
        System.out.println("Minimum Maximum Difference: " + (largest - smallest));
    }
}
