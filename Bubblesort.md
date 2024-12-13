### Bubble Sort
- Bubble sort is a simple sorting algorithm that repeatedly steps through the list, compares adjacent
  elements, and swaps them if they are in the wrong order. This process is repeated until the list is sorted.
- It is called "bubble sort" because the smaller elements "bubble" to the top (beginning of the list) with each pass.

 **Steps of the Bubble Sort Algorithm:**
- Starting at the beginning of the list, compare the first two elements.
- If the first element is greater than the second element, swap them.
- Move to the next pair of elements and repeat the comparison and swap if necessary.
- Continue this process for every pair of adjacent elements until you reach the end of the list.
- After the first pass, the largest element will have "bubbled up" to its correct position.
- Repeat the process for the remaining unsorted portion of the list.
- Each subsequent pass will leave the next largest element in its correct position.
- Stop when no swaps are made during a pass, indicating that the list is fully sorted.

### Time Complexity:
- **Worst-case time complexity:** O(n^2)when the list is in reverse order.
- **Best-case time complexity:** O(n) when the list is already sorted (with an optimized version that checks for swaps).
- **Average-case time complexity:** O(n^2)
  
### Space Complexity:
- **space complexity:** O(1)

**Example**
```java
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
```
