package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
public class ArrangeOddEvenTest {

    static int [] arrangeOddEvenElement(int[]array)
    {
        int start = 0;                  // Pointer for the start of the array
        int end = array.length - 1;       // Pointer for the end of the array

        // Use a single `for` loop to rearrange the array
        while(start<end) {
            if (array[start] % 2 != 0) {  // If the current element is odd, move to the next
                start++;
            } else if (array[end] % 2 == 0) {  // If the current element is even, move backward
                end--;
            } else {  // Swap when start points to even and end points to odd
                int temp = array[start];
                array[start] = array[end];
                array[end] = temp;
                start++;
                end--;
            }
        }
        return array;
    }
    public static void main(String[] args) {
        int[] arr = {8, 3, 5, 10, 15, 1, 17, 6};
        System.out.println("Array before arrangement:");
        System.out.println(Arrays.toString(arr));
        ArrangeOddEvenTest.arrangeOddEvenElement(arr);
        System.out.println("Array after arrangement:");
        System.out.println(Arrays.toString(arr));
    }
    @Test
    void arrangeOddEvenElementNormalTest() {
        int[] input = {11, 2, 4, 45, 20, 12, 7, 8};
        int[] expected = {11, 7, 45, 4, 20, 12, 2, 8}; // Expected result (odd numbers first)
        assertArrayEquals(expected, arrangeOddEvenElement(input)); // Compare contents
    }

    @Test
    void arrangeOddEvenElementEmptyArrayTest() {
        int[] input = {}; // Empty array
        int[] expected = {};
        assertArrayEquals(expected, arrangeOddEvenElement(input)); // Should return an empty array
    }

    @Test
    void arrangeOddEvenElementAllOddTest() {
        int[] input = {3, 5, 7, 9};
        int[] expected = {3, 5, 7, 9}; // No rearrangement needed
        assertArrayEquals(expected, arrangeOddEvenElement(input));
    }

    @Test
    void arrangeOddEvenElementAllEvenTest() {
        int[] input = {2, 4, 6, 8};
        int[] expected = {2, 4, 6, 8}; // No rearrangement needed
        assertArrayEquals(expected, arrangeOddEvenElement(input));
    }

    @Test
    void arrangeOddEvenElementMixedTest() {
        int[] input = {8, 3, 5, 10, 15, 1, 17, 6};
        int[] expected = {17, 3, 5, 1, 15, 10, 8, 6}; // Odd numbers followed by even numbers
        assertArrayEquals(expected, arrangeOddEvenElement(input));
    }
}