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
