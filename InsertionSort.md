### Insertion Sort
- Insertion Sort is a simple sorting algorithm that builds the final sorted array one item at a time.
- It is much like sorting playing cards in your hands.
- The idea is to take each element from the unsorted portion of the array and insert it into its correct position in the sorted portion of the array.

**Steps of the Insertion Sort Algorithm:**
- **Start with the second element** (since a single element is trivially sorted).
- Compare it with the elements before it in the sorted portion.
- Shift the larger elements to the right to make space for the current element.
- Insert the current element into its correct position in the sorted portion of the array.
- Repeat this process for all remaining elements in the array.

  ### Time Complexity:
- **Worst-case time complexity:** O(n^2)when the list is in reverse order.
- **Best-case time complexity:** O(n) when the list is already sorted (with an optimized version that checks for swaps).
- **Average-case time complexity:** O(n^2)
  
### Space Complexity:
- **space complexity:** O(1)

**Example**
```java

public class InsertionSort
{
    public static void insertionSort(int[] arr)
    {
        int arrayLength = arr.length;
        // traverse array
        for (int index = 1; index < arrayLength; index++)
        {
            int sorted_part = arr[index]; // store 1st index to the sorted_part variable
            int current = index - 1; // initalize j index brfore i index

            // check if jth index value is greater than sorted_part variable
            while (current >= 0 && arr[current] > sorted_part)
            {
                arr[current + 1] = arr[current]; // if yes the swap index
                current--;
            }

            arr[current + 1] = sorted_part;
        }
    }

    public static void main(String[] args)
    {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        insertionSort(arr);
        for (int num : arr)
        {
            System.out.print(num + " ");
        }
    }
}
```
