package com.example;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.arrays.ReverseIntArray;
import com.arrays.SortArrayExample;
import org.junit.jupiter.api.Test;

public class SortArrayTest {
    @Test
    void testAlreadySortedArray() {
        int[] input = {0, 1, 2};
        int[] expected = {2, 1, 0};
        assertArrayEquals(expected, SortArrayExample.sortArrayElement(input));
    }
}

