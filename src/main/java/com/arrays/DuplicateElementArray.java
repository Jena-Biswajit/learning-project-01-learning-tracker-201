package com.arrays;

import java.util.Arrays;

public class DuplicateElementArray {

    public static void findMissingAndDuplicate(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n + 1]; // Auxiliary array

        int duplicate = -1;
        int missing = -1;

        // Mark the visited numbers
        for (int num : nums) {
            if (visited[num]) {
                duplicate = num; // Duplicate found
            } else {
                visited[num] = true;
            }
        }

        // Find the missing number
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                missing = i;
                break;
            }
        }

        // Print the result
        System.out.println("Duplicate: " + duplicate);
        System.out.println("Missing: " + missing);
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 6, 2, 1, 1};
        findMissingAndDuplicate(nums); // Example
    }
}
