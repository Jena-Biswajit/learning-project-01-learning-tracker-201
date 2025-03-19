package com.arrays;

public class TwoSum {
   static class Solution {
        public int[] twoSum(int[] nums, int target) {
    
           int len = nums.length;
           int start =0  , end =len ;
           
    
           for( ; start<end;  ){
                    if((nums[start] + nums[end]) == target){
                        break;
                    }
                }   

           return new int[]{start, end};
        }
    }


    public static void main(String[] args) {
        int [] array = {2,7,11,9};
        int target = 9;

        Solution ob1 = new Solution();
        int [] resultArray =ob1.twoSum(array,target);
    }
}
