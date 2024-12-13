## Quick Sort
- Quick Sort is Merge Sort is a divide-and-conquer sorting algorithm that works by choosing a pivot element from the array.
- partitioning the other elements into two subarrays according to whether they are smaller or larger than the pivot.
- The subarrays are then recursively sorted. It is known for its average-case time complexity of 𝑂(𝑛log⁡𝑛),
- although it can degrade to 𝑂(𝑛2) in the worst case if the pivot is poorly chosen.

**Steps of the Quick Sort Algorithm:**
- **Choose a pivot:** Select an element from the array (often the first, last, middle, or a random element).
- **Partition:** Rearrange the array so that elements smaller than the pivot come before it, and elements greater than the pivot come after it.
- **Recursively sort** the subarrays formed by splitting the array at the pivot.
- Repeat until the array is sorted.
  
## Time and Space Complexity:
- **Time Complexity:**
- **Best, and Average-case:** O(nlogn), where n is the number of elements in the array.
- This is because the array is divided in half at each level (logarithmic division), and at each level, the merging process takes linear time (O(n))
- **Worst case** O(n2), which occurs when the pivot consistently divides the array into highly unbalanced subarrays
  (e.g., when the pivot is always the smallest or largest element).
## Space Complexity:
- O(n), because merge sort requires extra space for the temporary subarrays (left and right) during the merge process.
  
**Example**
```java  
public class QuickSort
{
  // Quick Sort Function
    public static void quickSort(int[] array, int low, int high)
    {
        if (low < high)
        {
            // Partition the array
            int pivotIndex = partition(array, low, high);

            // Recursively sort elements before and after the pivot
            quickSort(array, low, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, high);
        }
    }

    // Partition Function
    public static int partition(int[] array, int low, int high)
    {
        // Choose the pivot (last element in this case)
        int pivot = array[high];
        int prev = low - 1; // Index for smaller element

        for (int current = low; current < high; current++)
        {
            // If the current element is smaller than or equal to the pivot
            if (array[current] <= pivot)
            {
                prev++;
                // Swap array[i] and array[j]
                int temp = array[prev];
                array[prev] = array[current];
                array[current] = temp;
            }
        }

        // Place the pivot in its correct position
        int temp = array[prev + 1];
        array[prev + 1] = array[high];
        array[high] = temp;

        return prev + 1; // Return the pivot index
    }

    public static void main(String[] args)
    {
        int[] array = {10, 7, 8, 9, 1, 5,6};
        int n = array.length;

        System.out.println("Original Array:");
        for (int num : array)
        {
            System.out.print(num + " ");
        }

        quickSort(array, 0, n - 1);

        System.out.println("\nSorted Array:");
        for (int num : array)
        {
            System.out.print(num + " ");
        }
    }
}
```
