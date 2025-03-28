## Explanation of Each Statement

### Initialization
```java
int[] arr = {8, 3, 5, 10, 15, 1, 17, 6};
```
- Declares and initializes a 1D array `arr` containing both odd and even integers.

### Printing Array Before Rearrangement
```java
System.out.println("Array before arrangement:");
for (int index = 0; index < arr.length; index++) {
    System.out.print(arr[index] + " ");
}
System.out.println();
```
- A `for` loop iterates through each index `index` of the array.
- Prints each element of the array followed by a space.
- A newline is printed after all elements.

### Rearrangement Logic
```java
int start = 0;
int end = arr.length - 1;

for (; start < end; ) {
    if (arr[start] % 2 != 0) {
        start++;
    } else if (arr[end] % 2 == 0) {
        end--;
    } else {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}
```
1. **Initialization**:
    - `start`: Points to the beginning of the array.
    - `end`: Points to the end of the array.

2. **For Loop Logic**:
    - The loop continues until `start` is less than `end`.

3. **Odd Check**:
    - If `arr[start]` is odd, increment the `start` pointer.

4. **Even Check**:
    - If `arr[end]` is even, decrement the `end` pointer.

5. **Swap Condition**:
    - If `arr[start]` is even and `arr[end]` is odd, swap their values and adjust both pointers.

### Printing Array After Rearrangement
```java
System.out.println("Array after arrangement:");
for (int index = 0; index < arr.length; index++) {
    System.out.print(arr[index] + " ");
}
System.out.println();
```
- Similar to the initial printing logic, but prints the rearranged array.

## Example Output
**Input Array:** `{8, 3, 5, 10, 15, 1, 17, 6}`

**Output:**
```
Array before arrangement:
8 3 5 10 15 1 17 6 
Array after arrangement:
17 3 5 1 15 10 8 6
```

