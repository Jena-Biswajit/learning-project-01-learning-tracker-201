package com.arrays;

public class ReverseInGroups {
    public static int[] reverseElement(int[] array, int groupSize) {

        int len = array.length;
        for (int i = 0; i < len; i += groupSize) {
            int left = i;
            int right;

            if (i + groupSize - 1 < len) {
                right = i + groupSize - 1;
            } else {
                right = len - 1;
            }

            // iterate till left is greater than or equal
            while (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
                left++;
                right--;
            }

        }

        return array;
    }
}
