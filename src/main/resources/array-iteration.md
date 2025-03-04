### Iteration Example

**Using for loop:**
- The for loop is the most commonly used loop when you know the number of iterations in advance (e.g., iterating over the length of an array).
- In this case, the loop iterates over the array starting from the second element (index 1) and checks if the current element is greater than the max1 value.
- If it is, it updates the max1 value.

**Using for-each loop:**
- The for-each loop is used for iterating over arrays or collections.
- It simplifies the loop syntax, making it more readable when you do not need the index of the array elements.
- Here, each element of the array is directly compared with the current max2 value, and if it's greater, max2 is updated.

**Using while loop:**
- The while loop continues as long as the specified condition is true.
- Here, it starts at index 1 and compares each element with max3. If the element is greater than max3, it updates max3. The loop continues until the condition i < numbers.length becomes false.

**Using do-while loop:**
- The do-while loop guarantees at least one iteration because the condition is checked after the loop body is executed.
- In this example, it behaves similarly to the while loop but ensures that the comparison is made at least once before checking the condition.

**Example**
```java
package com.arrays;

// simple example for finding greatest element of array
public class OneDArrayIteration {
    public static void main(String[] args) {
        int[] numbers = {34, 67, 23, 89, 12, 95, 42};

        // Using for loop
        int maxFor = Integer.MIN_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > maxFor) {
                maxFor = numbers[i];
            }
        }
        System.out.println("Greatest using for loop: " + maxFor);

        // Using for-each loop
        int maxForEach = Integer.MIN_VALUE;
        for (int num : numbers) {
            if (num > maxForEach) {
                maxForEach = num;
            }
        }
        System.out.println("Greatest using for-each loop: " + maxForEach);

        // Using while loop
        int maxWhile = Integer.MIN_VALUE;
        int indexWhile = 0;
        while (indexWhile < numbers.length) {
            if (numbers[indexWhile] > maxWhile) {
                maxWhile = numbers[indexWhile];
            }
            indexWhile++;
        }
        System.out.println("Greatest using while loop: " + maxWhile);

        // Using do-while loop
        int maxDoWhile = Integer.MIN_VALUE;
        int indexDoWhile = 0;
        do {
            if (numbers[indexDoWhile] > maxDoWhile) {
                maxDoWhile = numbers[indexDoWhile];
            }
            indexDoWhile++;
        } while (indexDoWhile < numbers.length);
        System.out.println("Greatest using do-while loop: " + maxDoWhile);
    }
}
```

**2-D-Array-Iteration**
**Example**
```java
package com.arrays;
// simple example of finding sum of elements in 2-d array
public class TwoDArrayIteration {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // Using for loop
        int sumFor = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                sumFor += matrix[i][j];
            }
        }
        System.out.println("Sum using for loop: " + sumFor);

        // Using for-each loop
        int sumForEach = 0;
        for (int[] row : matrix) {
            for (int element : row) {
                sumForEach += element;
            }
        }
        System.out.println("Sum using for-each loop: " + sumForEach);

        // Using while loop
        int sumWhile = 0;
        int rowWhile = 0;
        while (rowWhile < matrix.length) {
            int colWhile = 0;
            while (colWhile < matrix[rowWhile].length) {
                sumWhile += matrix[rowWhile][colWhile];
                colWhile++;
            }
            rowWhile++;
        }
        System.out.println("Sum using while loop: " + sumWhile);

        // Using do-while loop
        int sumDoWhile = 0;
        int rowDoWhile = 0;
        do {
            int colDoWhile = 0;
            do {
                sumDoWhile += matrix[rowDoWhile][colDoWhile];
                colDoWhile++;
            } while (colDoWhile < matrix[rowDoWhile].length);
            rowDoWhile++;
        } while (rowDoWhile < matrix.length);
        System.out.println("Sum using do-while loop: " + sumDoWhile);
    }
}
```