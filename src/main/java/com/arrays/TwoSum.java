package com.arrays;

import java.util.Arrays;

public class TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {

            int len = nums.length;

            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    if (nums[i] + nums[j] == target) {
                        return new int[] { i, j };
                    }
                }

            }
            return new int[] {};
        }
    }

    public static void main(String[] args) {
        int[] array = { 2, 11, 7, 9 };
        int target = 9;

        Solution ob1 = new Solution();
        int[] resultArray = ob1.twoSum(array, target);
        System.out.println(Arrays.toString(resultArray));
    }
}
