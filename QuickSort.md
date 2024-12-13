Quick Sort is another highly efficient sorting algorithm that works by choosing a pivot element from the array and partitioning the other elements into two subarrays according to whether they are smaller or larger than the pivot. The subarrays are then recursively sorted. It is known for its average-case time complexity of 
𝑂
(
𝑛
log
⁡
𝑛
)
O(nlogn), although it can degrade to 
𝑂
(
𝑛
2
)
O(n 
2
 ) in the worst case if the pivot is poorly chosen.

Steps of the Quick Sort Algorithm:
Choose a pivot: Select an element from the array (often the first, last, middle, or a random element).
Partition: Rearrange the array so that elements smaller than the pivot come before it, and elements greater than the pivot come after it.
Recursively sort the subarrays formed by splitting the array at the pivot.
Repeat until the array is sorted.
