package com.arrays;
import java.util.Arrays;
class ArrangeOddEven {
    static int[] arrangeOddEven(int[] arr) {

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
        return arr;
    }

}
    public class ArrangeArrayElement {
        public static void main(String[] args) {
            int[] arr = {8, 3, 5, 10, 15, 1, 17, 6};
            System.out.println("Array before arrangement:");
            System.out.println(Arrays.toString(arr));
            ArrangeOddEven.arrangeOddEven(arr);
            System.out.println("Array after arrangement:");
            System.out.println(Arrays.toString(arr));
        }

    }


