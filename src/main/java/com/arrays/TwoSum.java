package com.arrays;

import java.util.Arrays;

public class TwoSum {
    static class Solution {
        public int[] twoSum(int[] nums, int target) {
    
           int len = nums.length;
           int start =0  , end =len ;
           
    
           for( start =0 ; start<len-1 ;start++  ){
                for(end = len ; end>0 ;end--  ){
    
                    if((nums[start] + nums[end]) == target){
                        break;
                    }
                }   
           }
           return new int[]{start, end};
        }
    }

    public static void main(String[] args) {
        int[] array = {2, 11, 7, 9};
        int target = 9;

        Solution ob1 = new Solution();
        int[] resultArray = ob1.twoSum(array, target);
        System.out.println(Arrays.toString(resultArray));
    }
}
