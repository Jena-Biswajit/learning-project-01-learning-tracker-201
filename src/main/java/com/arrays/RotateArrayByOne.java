package com.arrays;

import java.util.Arrays;

public class RotateArrayByOne {

    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 8 };

        System.out.println("array before rotate " + Arrays.toString(array));

        int len = array.length;

        for (int i = 0; i < len; i++) {

            int temp;
            temp = array[i];
            array[i] = array[len - 1];
            array[len - 1] = temp;
        }

        System.out.println("array after rotate " + Arrays.toString(array));
    }

}
