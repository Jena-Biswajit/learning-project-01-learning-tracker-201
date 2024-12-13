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
  
