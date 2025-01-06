package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class RemoveDuplicateElementTest {
    static int[] removedDuplicate(int[] array) {
        boolean visited = false;
        int len = array.length - 1;
        int index = 0;
        for (int i = 0; i <= len; i++) {

            boolean isDuplicate = false;
            for (int j = 0; j < index; j++) {
                if (array[i] == array[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                array[index++] = array[i];
            }

        }
        while (index < array.length) {
            array[index++] = 0;
        }


        return array;
    }

    public static void main(String[] args) {

        int[] arr = {1, 1, 2, 5, 2, 6, 5, 2, 6};
        System.out.println("array before remove duplicate element" + Arrays.toString(arr));
        RemoveDuplicateElementTest.removedDuplicate(arr);
        System.out.println("array after removing duplicate elements" + Arrays.toString(arr));
    }

    @Test
    void testRemoveDuplicateWithDuplicates() {
        int[] input = {1, 1, 2, 5, 2, 6, 5, 2, 6};
        int[] expected = {1, 2, 5, 6, 0, 0, 0, 0, 0}; // After removing duplicates
        assertArrayEquals(expected, RemoveDuplicateElementTest.removedDuplicate(input));
    }

    @Test
    void testRemoveDuplicateWithoutDuplicates() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5}; // No duplicates, so output should match input
        assertArrayEquals(expected, RemoveDuplicateElementTest.removedDuplicate(input));
    }

    @Test
    void testRemoveDuplicateWithAllSameElements() {
        int[] input = {7, 7, 7, 7};
        int[] expected = {7, 0, 0, 0}; // Only one unique value
        assertArrayEquals(expected, RemoveDuplicateElementTest.removedDuplicate(input));
    }

    @Test
    void testRemoveDuplicateWithEmptyArray() {
        int[] input = {};
        int[] expected = {}; // Empty array should remain empty
        assertArrayEquals(expected, RemoveDuplicateElementTest.removedDuplicate(input));
    }

    @Test
    void testRemoveDuplicateWithSingleElement() {
        int[] input = {42};
        int[] expected = {42}; // Single element array should remain unchanged
        assertArrayEquals(expected, RemoveDuplicateElementTest.removedDuplicate(input));
    }
}
