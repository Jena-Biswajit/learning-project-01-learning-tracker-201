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

