package com.arrays;

import java.util.Arrays;
import java.util.*;


public class MaximumSumSubArrays {
    public static void main(String[] args) {
        int [] array = {2,3,4,-3,5,-5};
        int sum=0;
        System.out.println("Array before sum "+ Arrays.toString(array));


        for(int i = 0;i< array.length;i++ ){
            sum = sum+array[i];
        }

        System.out.println("result " + sum);
    }
}
