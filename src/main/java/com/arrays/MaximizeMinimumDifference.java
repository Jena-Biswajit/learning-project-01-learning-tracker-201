package com.arrays;

import java.util.Arrays;

public class MaximizeMinimumDifference {
    public static void main(String[] args) {
        int []array = {3,4,5,6,7};
        int len = array.length;
        int k = 2;
        int []temp = new int[len];

        for (int i =0; i<array.length;i++){
            if(array[i]> k){
                temp[i] = array[i] - k ;

            }
            else{
                temp[i] = array[i]+k;
            }
        }
        System.out.println(Arrays.toString(temp));
        int largest = temp.length, smallest=temp[0];

        Arrays.sort(temp);
        System.out.println("largest element is :"+ largest);
        System.out.println("smallest element is :"+ temp[0]);

        System.out.println("maximum minimum diff bet height is :"+ (largest-smallest));
    }
}



