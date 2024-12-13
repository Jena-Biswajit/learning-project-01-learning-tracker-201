## Merge Sort
- Merge Sort is a divide-and-conquer sorting algorithm that divides the array into two halves, recursively sorts each half,
  and then merges the two sorted halves into a single sorted array.
- It is efficient and has a predictable time complexity of O(nlogn), making it suitable for larger datasets.

**Steps of the Merge Sort Algorithm:**
- **Divide:** Split the array into two halves until each subarray contains only one element (which is trivially sorted).
- **Conquer:** Recursively sort each of the halves.
- **Combine:** Merge the two sorted halves back into a single sorted array.
## Time and Space Complexity:
- **Time Complexity:**
- **Best, Worst, and Average-case:** O(nlogn), where n is the number of elements in the array.
- This is because the array is divided in half at each level (logarithmic division), and at each level, the merging process takes linear time (O(n)) .

- **Space Complexity:**
- O(n), because merge sort requires extra space for the temporary subarrays (left and right) during the merge process.

  **Example**
  ```java
  
