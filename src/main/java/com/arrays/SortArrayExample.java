package com.arrays;

public class SortArrayExample {
    public static int[] sortArrayElement(int[] array) {

        int len = array.length - 1;
        for (int i = 0; i <= len; i++) {
            System.out.println("array before sorting :" + array[i]);
        }
        int[] sortedArray = new int[array.length];
        for (int i = 0; i <= len; i++) {
            sortedArray[i] = array[len - i];
        }
        for (int i = 0; i <= len; i++) {
            System.out.println("array after sorting :" + sortedArray[i]);
        }
        return sortedArray;
    }
}
