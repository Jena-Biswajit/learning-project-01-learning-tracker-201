package com.example.blind75.array;

import java.util.HashSet;
import java.util.Set;

public class HashDuplicate {

    public static void main(String[] args) {
        int[] originalArray = {1,2,3,4,5};
        boolean result = hashDuplicate(originalArray);
        System.out.println(result);
    }
    public static boolean hashDuplicate(int[] nums){
        if(nums == null){
            return false ;
        }
        Set<Integer> findDuplicate = new HashSet();
        for(int i =0 ; i<nums.length ; i++){
            if(findDuplicate.contains(nums[i])){
                return true ;
            }
            findDuplicate.add(nums[i]);
        }
        return false ;
    }
}
