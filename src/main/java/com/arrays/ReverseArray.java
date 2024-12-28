package com.arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        for (int num : arr) {
            System.out.println("Original array: " + num);
        }
        System.out.println("\n");
        ReverseIntArray ob1 = new ReverseIntArray();
        int[] reversed = ob1.reverseIntArray(arr);
        for (int num : reversed) {
            System.out.println("Reversed array: " + num);
        }
    }
}
