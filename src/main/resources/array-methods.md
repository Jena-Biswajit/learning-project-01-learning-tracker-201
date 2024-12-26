### 1. Arrays.hashCode(array)
   **Description:**
   - Returns a hash code for the contents of the specified array.
   - It considers the elements of the array and calculates a hash code.
   - Useful for quickly comparing arrays in hash-based collections.

### 2. Arrays.toString(array)
   **Description:**
   - Converts a one-dimensional array into a string representation.
   - The output is enclosed in square brackets ([]), and elements are separated by commas.

### 3. Arrays.equals(array1, array2)
   **Description:**
   - Compares two one-dimensional arrays for equality.
   - Returns true if both arrays are of the same length and contain the same elements in the same order.

### 4. Arrays.deepToString(array)
   **Description:**
   - Converts a multi-dimensional array into a string representation.
   - It works like toString but recursively formats nested arrays.

**Example**
```java
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
```
