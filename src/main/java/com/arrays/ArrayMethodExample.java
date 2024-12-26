package com.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMethodExample {

    public static void main(String[] args) {
        // Returns a hash code for the contents of the specified array.
        int[] arr = {1, 4, 2, 3};
        int[] arr1 = {1, 2, 3};
        int[][] multiArray = {{1, 2}, {3, 4}};
        int[][] multiArray1 = {{1, 2}, {3, 4}};

        int[][][] three_d_arr = {
                {{1, 2}, {3, 4}},
                {{4, 5}, {6, 7}}
        };

        for (int i = three_d_arr.length - 1; i >= 0; i--) {
            int[][] temp1 = three_d_arr[i];

            for (int j = temp1.length - 1; j >= 0; j--) {
                int[] temp2 = temp1[j];
                for (int k = temp2.length - 1; k >= 0; k--) {
                    int temp3 = temp2[k];
                    System.out.println(temp3);
                }
            }
        }
        System.out.println("--------------");

        for (int i = 0; i < three_d_arr.length; i++) {
            int[][] temp1 = three_d_arr[i];

            for (int j = 0; j < temp1.length; j++) {
                int[] temp2 = temp1[j];
                for (int k = 0; k < temp2.length; k++) {
                    int temp3 = temp2[k];
                    System.out.println(temp3);
                }
            }
        }


        int hash = arr.hashCode();
        System.out.println("hash code: " + hash);


        String printArr = Arrays.toString(arr);
        System.out.println("array as string: " + printArr);

        System.out.println("array getclass : " + arr.getClass());

        boolean identicalArray = Arrays.equals(arr, arr1);
        System.out.println("comparing two array : " + identicalArray);

        String print2DArray = Arrays.deepToString(multiArray);
        System.out.println("2d array as string : " + print2DArray);

        System.out.println("2d array getclass : " + multiArray.getClass());

        boolean identicalMultiArray = Arrays.deepEquals(multiArray, multiArray1);
        System.out.println("comparing two array : " + identicalMultiArray);
    }
}
