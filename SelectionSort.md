### Selection Sort
- Selection Sort is another simple sorting algorithm that works by repeatedly finding the minimum element
  from the unsorted part of the array and swapping it with the first unsorted element.
- It is called "selection" sort because it selects the smallest (or largest) element from the unsorted portion and moves it to the sorted portion.

**Steps of the Selection Sort Algorithm:**
- **Start with the first element in the array** (index 0) and assume it is the minimum element.
- Find the minimum element in the unsorted portion of the array (from the current index to the end of the array).
- **Swap the minimum element** found with the first unsorted element.
- Move the boundary between the sorted and unsorted portions of the array one step forward.
- **Repeat the process** for the remaining unsorted portion of the array until the whole array is sorted.

### Time Complexity:
- **Worst-case time complexity:** O(n^2)when the list is in reverse order.
- **Best-case time complexity:** O(n) when the list is already sorted (with an optimized version that checks for swaps).
- **Average-case time complexity:** O(n^2)
  
### Space Complexity:
- **space complexity:** O(1)

**Example**
```java
public class selectionSort
{
    public static void main(String[] args)
    {
        int[] arr = {64, 25, 12, 22, 11};

        System.out.println("unsorted array :");
        printArray(arr);

        selectionSort(arr);

        System.out.println("Sorted Array:");
        printArray(arr);
    }

    // Selection Sort function
    public static void selectionSort(int[] arr)
    {
        int arrayLength = arr.length;

        // Traverse through the entire array
        for (int index = 0; index < arrayLength - 1; index++)
        {
            // Find the minimum element in the unsorted part
            int minIndex = index;
            for (int current = index + 1; current < arrayLength; current++)
            {
                if (arr[current] < arr[minIndex])
                {
                    minIndex = current; // Update the index of the smallest element
                }
            }

            // Swap the found minimum element
            int temp = arr[minIndex];
            arr[minIndex] = arr[index];
            arr[index] = temp;
        }
    }
    public static void printArray(int[] arr)
    {
        for (int num : arr)
        {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
```
