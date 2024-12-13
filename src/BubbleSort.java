public class BubbleSort
{
    public static void bubbleSort(int[] arr)
    {
        //traverse array
        for(int index=0;index<arr.length-1;index++)
        {
            // if 1st index element is greater then swap
            int current=0;
            while(current<arr.length-1-index)
            {
                if(arr[current] > arr[current+1])
                {

                    int temp = arr[current];
                    arr[current]= arr[current+1];
                    arr[current+1] = temp ;
                }
                current++;
            }
        }

    }

    public static void main(String[]args)
    {
        int arr[] = {5,2,1,0,3,6};
        bubbleSort(arr);
        for (int num : arr)
        {
            System.out.print(num + " ");
        }
    }
}
