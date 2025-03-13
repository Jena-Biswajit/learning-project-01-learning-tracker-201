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
        int largest = 0,smallest=0;
        for(int i =0 ; i< array.length;i++){
            // find the smallest and largest
            if(temp[i]>temp[i+1]){
                 largest = array[i];
            } else if (temp[i]<temp[i+1]) {
                 smallest  = array[i];
            }
        }
        System.out.println(largest);
        System.out.println(smallest);
    }

}
