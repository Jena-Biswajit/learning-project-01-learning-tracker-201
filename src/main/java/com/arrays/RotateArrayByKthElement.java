package com.arrays;

import java.util.Arrays;

class RotateArray {

    public void rotateArr(int[] array, int position) {
        // result will be 5,7,83,2,1,23,4
        int len = array.length;
        for (int j = 0; j < position; j++) {
            for (int i = 0; i < len; i++) {

                int temp;
                temp = array[i];
                array[i] = array[len - 1];
                array[len - 1] = temp;
            }
        }   
        System.out.println("array after rotate " + Arrays.toString(array));
    }
}

public class RotateArrayByKthElement {
    public static void main(String[] args) {
        int[] arr = { 1, 23, 4, 5, 7, 83, 2 };

        int rotateElement = 3;

        RotateArray ob1 = new RotateArray();
        ob1.rotateArr(arr, rotateElement);
    }
}
