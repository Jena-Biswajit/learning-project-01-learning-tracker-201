package com.arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArrayMethodExample {

    public static void main(String[] args) {
        // Returns a hash code for the contents of the specified array.
        int[] arr = {1,4,2,3};
        int[] arr1 = {1,2,3};
        int[][] multiArray = {{1,2},{3,4}};
        int[][] multiArray1 = {{1,2},{3,4}};

        int hash = arr.hashCode();
        System.out.println("hash code: "+ hash);

        String printArr = Arrays.toString(arr);
        System.out.println("array as string: "+ printArr);

        boolean identicalArray = Arrays.equals(arr,arr1);
        System.out.println("comparing two array : "+ identicalArray);

        String print2DArray = Arrays.deepToString(multiArray);
        System.out.println("2d array as string : "+ print2DArray);

        boolean identicalMultiArray = Arrays.deepEquals(multiArray,multiArray1);
        System.out.println("comparing two array : "+ identicalMultiArray);
    }
}
