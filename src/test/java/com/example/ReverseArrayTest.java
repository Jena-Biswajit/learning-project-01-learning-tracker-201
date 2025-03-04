package com.example;

import static org.junit.jupiter.api.Assertions.*;

import com.arrays.ReverseIntArray;
import org.junit.jupiter.api.Test;

class ReverseIntArrayTest {

    @Test
    void testReverseIntArray() {
        int[] input = {1, 2, 3, 4, 5};
        int[] expected = {5, 4, 3, 2, 1};

        assertArrayEquals(expected, ReverseIntArray.reverseIntArray(input));
    }

    @Test
    void testEmptyArray() {
        int[] input = {};
        int[] expected = {};

        assertArrayEquals(expected, ReverseIntArray.reverseIntArray(input));
    }

    @Test
    void testSingleElementArray() {
        int[] input = {10};
        int[] expected = {10};

        assertArrayEquals(expected, ReverseIntArray.reverseIntArray(input));
    }
}

