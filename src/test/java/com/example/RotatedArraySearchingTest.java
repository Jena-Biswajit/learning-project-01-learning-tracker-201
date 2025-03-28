package com.example;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RotatedArraySearchingTest {
    public static int searchInRotatedArray(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Check if left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int []arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 6;
       int result= RotatedArraySearchingTest.searchInRotatedArray(arr,target);
        System.out.println("Index of target is: " + result);
    }
    @Test
    void testSearchInRotatedArrayTargetExists() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 6;
        int expectedIndex = 2;
        assertEquals(expectedIndex, RotatedArraySearchingTest.searchInRotatedArray(nums, target));
    }

    @Test
    void testSearchInRotatedArrayTargetAtStart() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 4;
        int expectedIndex = 0;
        assertEquals(expectedIndex, RotatedArraySearchingTest.searchInRotatedArray(nums, target));
    }

    @Test
    void testSearchInRotatedArrayTargetAtEnd() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 2;
        int expectedIndex = 6;
        assertEquals(expectedIndex, RotatedArraySearchingTest.searchInRotatedArray(nums, target));
    }

    @Test
    void testSearchInRotatedArrayTargetNotExists() {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 10;
        int expectedIndex = -1; // Target not found
        assertEquals(expectedIndex, RotatedArraySearchingTest.searchInRotatedArray(nums, target));
    }

    @Test
    void testSearchInRotatedArraySingleElementFound() {
        int[] nums = {5};
        int target = 5;
        int expectedIndex = 0; // Only one element
        assertEquals(expectedIndex, RotatedArraySearchingTest.searchInRotatedArray(nums, target));
    }

    @Test
    void testSearchInRotatedArraySingleElementNotFound() {
        int[] nums = {5};
        int target = 3;
        int expectedIndex = -1; // Element not found
        assertEquals(expectedIndex, RotatedArraySearchingTest.searchInRotatedArray(nums, target));
    }

    @Test
    void testSearchInRotatedArrayEmptyArray() {
        int[] nums = {};
        int target = 3;
        int expectedIndex = -1; // Empty array
        assertEquals(expectedIndex, RotatedArraySearchingTest.searchInRotatedArray(nums, target));
    }

    @Test
    void testSearchInRotatedArrayNoRotation() {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int target = 3;
        int expectedIndex = 2; // No rotation, target is at index 2
        assertEquals(expectedIndex, RotatedArraySearchingTest.searchInRotatedArray(nums, target));
    }

    @Test
    void testSearchInRotatedArrayAllSameElements() {
        int[] nums = {5, 5, 5, 5};
        int target = 5;
        int expectedIndex = 1; // Any index could be valid
        assertEquals(expectedIndex, RotatedArraySearchingTest.searchInRotatedArray(nums, target));
    }
}
