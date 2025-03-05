package com.arrays;
import java.util.Arrays;
import java.util.*;


public class MaximumSumSubArrays {
    public static void main(String[] args) {
        int [] array = {2,3,4,-9,-3,5,5,-5};
        int sum=0;
        int maxSum = 0;

        System.out.println("Array before sum "+ Arrays.toString(array));


        for(int i = 0;i< array.length;i++ ){
            if (sum<0) {
                //Assign 0 to sum when sum is negative
                sum=0;                           
            }
            sum = sum+array[i];

            // maxSum will be assigned the larger value between sum and the current value of maxSum
            maxSum = Math.max(sum,maxSum);
        }
        System.out.println(maxSum);

        System.out.println("result " + sum);
    }
}