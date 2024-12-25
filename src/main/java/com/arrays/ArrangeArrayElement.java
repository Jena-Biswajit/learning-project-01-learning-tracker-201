package com.arrays;

class ArrangeOddEven {
    public void arrangeOddEven() {
        int[] arr = {8, 3, 5, 10, 15, 1, 17, 6};
        System.out.println("Array before arrangement:");
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + " ");
        }
        System.out.println();

        int start = 0;                  // Pointer for the start of the array
        int end = arr.length - 1;       // Pointer for the end of the array

        // Use a single `for` loop to rearrange the array
        for (; start < end; ) {
            if (arr[start] % 2 != 0) {  // If the current element is odd, move to the next
                start++;
            } else if (arr[end] % 2 == 0) {  // If the current element is even, move backward
                end--;
            } else {  // Swap when start points to even and end points to odd
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        System.out.println("Array after arrangement:");
        for (int index = 0; index < arr.length; index++) {
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }
}

public class ArrangeArrayElement {
    public static void main(String[] args) {
        ArrangeOddEven ob1 = new ArrangeOddEven();
        ob1.arrangeOddEven();
    }
}
