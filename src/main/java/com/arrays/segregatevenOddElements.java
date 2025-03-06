package com.arrays;

public class segregatevenOddElements {

    // Function to move all -ve element to end of array
    // in same order.
    static void segregateElements(int[] arr) {

        // segregate negative element in order
        // result would be -1 -3 -2 1 7 5 11 6 or
        // 1 7 5 11 6 -1 -3 -2

        int len = arr.length;
        int start = 0, end = len - 1;
        for (; start < end;) {

            // first check for the negative element
            if (arr[start] < 0) {
                // do nothing and traverse
                start++;
            } else if (arr[end] > 0) {
                end--;
            } else {

                // swap and traverse
                int temp = 0;
                temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;

                start++;
                end--;

            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 1, -1, -3, 7, 5, 11, 6, -2 };
        segregateElements(arr);

        for (int ele : arr)
            System.out.print(ele + " ");
    }
}
