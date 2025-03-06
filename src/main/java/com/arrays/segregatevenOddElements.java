package com.arrays;

public class segregatevenOddElements {

    // Function to move all -ve element to end of array
    // in same order.
    static void segregateElements(int[] arr) {

        // segregate negative element in order
        // result would be -1 -3 -2 1 7 5 11 6 or
        // 1 7 5 11 6 -1 -3 -2

        int negIndex = 0; // Pointer for negative numbers

        for (int posIndex = 0; posIndex < arr.length; posIndex++) {
            if (arr[posIndex] < 0) {
                // If negative number found, shift elements right and insert at negIndex
                int negNumber = arr[posIndex];
                int tempIndex = posIndex;

                while (tempIndex > negIndex) {
                    arr[tempIndex] = arr[tempIndex - 1];
                    tempIndex--;
                }

                arr[negIndex] = negNumber;
                negIndex++; // Move negative index forward
            }
            // Use 'elseif' to ensure that positive numbers are left untouched
            else if (arr[posIndex] >= 0) {
                // Simply move to the next element
                continue;
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
