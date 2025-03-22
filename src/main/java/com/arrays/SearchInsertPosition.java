package com.arrays;


class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            if (nums[i] == target) {
                return i;
            } else {
                if (nums[i] > target) {
                    if (nums[i - 1] < target) {
                        return i;
                    }
                } else {
                    if (nums[len - 1] < target) {
                        return len;
                    }
                }
            }

        }
        return 0;
    }
}

public class SearchInsertPosition {

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 5, 7};
        int target = 8;
        Solution ob1 = new Solution();
        int result = ob1.searchInsert(array, target);
        System.out.println(result);
    }
}

