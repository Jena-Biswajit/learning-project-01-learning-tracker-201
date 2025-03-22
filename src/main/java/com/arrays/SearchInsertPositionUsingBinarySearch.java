package com.arrays;

class SolutionUsingTwoPointer {
    public int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length-1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (nums[mid] == target) {
                return mid;
            }
            else if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
}

public class SearchInsertPositionUsingBinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 7};
        int target = 8;
        SolutionUsingTwoPointer ob1 = new SolutionUsingTwoPointer();
        int result = ob1.searchInsert(array, target);
        System.out.println(result);
    }
}

