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

