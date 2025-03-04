### 2D Array Iteration: Row-Major and Column-Major Order

A 2D array is a collection of elements arranged in rows and columns. Iteration through a 2D array can be done in two main ways:

1. **Row-Major Order**: Traverse all elements row by row.
2. **Column-Major Order**: Traverse all elements column by column.

Here is a detailed explanation and example for each approach.

## Example 2D Array

Consider the following 2D array:

```
int[][] array = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
```

### Dimensions
- Rows: 3 (0, 1, 2)
- Columns: 3 (0, 1, 2)

## 1. Row-Major Order Iteration
In this approach, we iterate through each row, and for each row, iterate through all its columns.

### Code
```java
public class ArrayIteration {
    public static void main(String[] args) {
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Row-Major Order:");
        for (int row = 0; row < array.length; row++) { // Iterate over rows
            for (int col = 0; col < array[row].length; col++) { // Iterate over columns of the current row
                System.out.print(array[row][col] + " ");
            }
            System.out.println(); // New line after each row
        }
    }
}
```

### Explanation
1. **Outer Loop**:
    - `for (int row = 0; row < array.length; row++)`: Iterates over each row.
    - `array.length` gives the number of rows.

2. **Inner Loop**:
    - `for (int col = 0; col < array[row].length; col++)`: Iterates over columns of the current row.
    - `array[row].length` gives the number of columns in the current row.

3. **Accessing Elements**:
    - `array[row][col]`: Accesses the element at the given row and column.

### Output
```
Row-Major Order:
1 2 3 
4 5 6 
7 8 9 
```

## 2. Column-Major Order Iteration
In this approach, we iterate through each column, and for each column, iterate through all its rows.

### Code
```java
public class ArrayIteration {
    public static void main(String[] args) {
        int[][] array = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println("Column-Major Order:");
        for (int col = 0; col < array[0].length; col++) { // Iterate over columns
            for (int row = 0; row < array.length; row++) { // Iterate over rows of the current column
                System.out.print(array[row][col] + " ");
            }
            System.out.println(); // New line after each column
        }
    }
}
```

### Explanation
1. **Outer Loop**:
    - `for (int col = 0; col < array[0].length; col++)`: Iterates over each column.
    - `array[0].length` gives the number of columns.

2. **Inner Loop**:
    - `for (int row = 0; row < array.length; row++)`: Iterates over rows of the current column.

3. **Accessing Elements**:
    - `array[row][col]`: Accesses the element at the given row and column.

### Output
```
Column-Major Order:
1 4 7 
2 5 8 
3 6 9 
```

## Comparison of Iteration Methods

| Feature             | Row-Major Order                  | Column-Major Order                   |
|---------------------|----------------------------------|--------------------------------------|
| Traversal Sequence  | Row by row                       | Column by column                     |
| Outer Loop Variable | Represents rows                  | Represents columns                   |
| Inner Loop Variable | Represents columns of each row   | Represents rows of each column       |
| Access Pattern      | `array[row][col]`                | `array[row][col]`                    |

### Notes
- **Memory Layout**: Although Java uses row-major order internally, the column-major iteration logic is purely for accessing elements differently.
- **Use Cases**:
    - **Row-Major**: Commonly used for tasks like row-wise operations (e.g., matrix addition).
    - **Column-Major**: Useful in column-specific operations (e.g., column averages).