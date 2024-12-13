public class MergeSort
{
    public static void main(String[] args)
    {
        int[] array = {38, 27, 43, 3, 9, 82, 10};

        System.out.println("Original Array:");
        printArray(array);

        mergeSort(array, 0, array.length - 1);

        System.out.println("\nSorted Array:");
        printArray(array);
    }

    // Recursive merge sort function
    public static void mergeSort(int[] array, int left, int right)
    {
        if (left < right)
        {
            int middle = left + (right - left) / 2; // Find the middle point

            // Recursively sort the left and right halves
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Merge the sorted halves
            merge(array, left, middle, right);
        }
    }

    // Merge function to combine two sorted subarrays
    public static void merge(int[] array, int left, int middle, int right)
    {
        int num1 = middle - left + 1; // Size of left subarray
        int num2 = right - middle;   // Size of right subarray

        // Create temporary arrays
        int[] leftArray = new int[num1];
        int[] rightArray = new int[num2];

        // Copy data to temp arrays
        for (int index = 0; index < num1; index++)
            leftArray[index] = array[left + index];
        for (int current = 0; current < num2; current++)
            rightArray[current] = array[middle + 1 + current];

        // Merge the temp arrays back into the original array
        int index = 0, current = 0;
        int initialIndex = left; // Initial index of merged subarray
        while (index < num1 && current < num2)
        {
            if (leftArray[index] <= rightArray[current])
            {
                array[initialIndex] = leftArray[index];
                index++;
            } else {
                array[initialIndex] = rightArray[current];
                current++;
            }
            initialIndex++;
        }

        // Copy remaining elements of leftArray (if any)
        while (index < num1)
        {
            array[initialIndex] = leftArray[index];
            index++;
            initialIndex++;
        }

        // Copy remaining elements of rightArray (if any)
        while (current < num2)
        {
            array[initialIndex] = rightArray[current];
            current++;
            initialIndex++;
        }
    }

    // Utility function to print the array
    public static void printArray(int[] array)
    {
        for (int value : array)
        {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
