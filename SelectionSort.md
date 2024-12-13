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
