package com.example;
import static org.junit.jupiter.api.Assertions.*;
import com.arrays.ReverseInGroups;
import org.junit.jupiter.api.Test;
public class ReverseArrayInGroupsTest {
    @Test
    void testReverseInGroupsNormalCase() {
        int[] arr = {5, 2, 7, 8, 1, 0, 3, 6};
        int groupSize = 3;
        int[] expected = {7, 2, 5, 0, 1, 8, 6, 3};
        assertArrayEquals(expected, ReverseInGroups.reverseElement(arr, groupSize));
    }

    @Test
    void testReverseInGroupsSingleElementGroup() {
        int[] arr = {5, 2, 7, 8};
        int groupSize = 1;
        int[] expected = {5, 2, 7, 8}; // No change
        assertArrayEquals(expected, ReverseInGroups.reverseElement(arr, groupSize));
    }

    @Test
    void testReverseInGroupsGroupSizeEqualsArrayLength() {
        int[] arr = {5, 2, 7, 8};
        int groupSize = 4;
        int[] expected = {8, 7, 2, 5};
        assertArrayEquals(expected, ReverseInGroups.reverseElement(arr, groupSize));
    }

    @Test
    void testReverseInGroupsGroupSizeLargerThanArrayLength() {
        int[] arr = {5, 2, 7};
        int groupSize = 5;
        int[] expected = {7, 2, 5}; // Reverse the entire array
        assertArrayEquals(expected, ReverseInGroups.reverseElement(arr, groupSize));
    }

    @Test
    void testReverseInGroupsEmptyArray() {
        int[] arr = {};
        int groupSize = 3;
        int[] expected = {}; // No change
        assertArrayEquals(expected, ReverseInGroups.reverseElement(arr, groupSize));
    }
}
