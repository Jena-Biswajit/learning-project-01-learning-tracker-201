package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FindSecondLowestElementTest {

    static int secondLowestElement(int[]array){

        int smallest = Integer.MAX_VALUE; // this will return (2^31 - 1) of int type.
        for (int num : array) {
            if (num < smallest) {
                smallest = num;
            }
        }

        // Find the smallest element larger than the `smallest`
        int secondSmallest = Integer.MAX_VALUE;
        for (int num : array) {
            if (num > smallest && num < secondSmallest) {
                secondSmallest = num;
            }
        }

        // If no second smallest exists, return Integer.MAX_VALUE
        return secondSmallest ;
    }
    public static void main(String[] args) {
        int[]arr={1,2,3,4,5,6};
        int secondSmallestElement = secondLowestElement(arr);
        System.out.println("second loewst element is :"+secondSmallestElement);
    }

    @Test
    void testFindSecondLargestNormalCase() {
        int[] arr = {5, 2, 7, 8, 1, 0, 3, 6};
        int expectedSecondSmallest = 1;
        assertEquals(expectedSecondSmallest, secondLowestElement(arr));
    }
}
