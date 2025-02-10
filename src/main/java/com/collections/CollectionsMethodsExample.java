package com.collections;
import java.util.*;

public class CollectionsMethodsExample {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 3, 9, 1, 7));

        // 1. Sort the list in ascending order
        Collections.sort(numbers);
        System.out.println("Sorted List: " + numbers); // Output: [1, 3, 5, 7, 9]

        // 2. Sort the list in descending order (using a comparator)
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Descending List: " + numbers); // Output: [9, 7, 5, 3, 1]

        // 3. Reverse the list
        Collections.reverse(numbers);
        System.out.println("Reversed List: " + numbers); // Output: [1, 3, 5, 7, 9]

        // 4. Shuffle the list
        Collections.shuffle(numbers);
        System.out.println("Shuffled List: " + numbers); // Random order

        // 5. Find the maximum and minimum elements
        int max = Collections.max(numbers);
        int min = Collections.min(numbers);
        System.out.println("Max: " + max + ", Min: " + min);

        // 6. Frequency of an element in the list
        numbers.add(5); // Add duplicate for testing frequency
        int frequency = Collections.frequency(numbers, 5);
        System.out.println("Frequency of 5: " + frequency);

        // 7. Create an unmodifiable list
        List<Integer> unmodifiableList = Collections.unmodifiableList(numbers);
        System.out.println("Unmodifiable List: " + unmodifiableList);
        // unmodifiableList.add(10); // Uncommenting this will throw UnsupportedOperationException

        // 8. Synchronized list (thread-safe)
        List<Integer> syncList = Collections.synchronizedList(numbers);
        synchronized (syncList) {
            System.out.println("Synchronized List: " + syncList);
        }

        // 9. Binary search (works on a sorted list)
        Collections.sort(numbers); // Sort again for binary search
        int index = Collections.binarySearch(numbers, 5);
        System.out.println("Index of 5 (Binary Search): " + index);

        // 10. Copy and Fill methods
        List<Integer> copyList = new ArrayList<>(Collections.nCopies(numbers.size(), 0)); // Initialize with the same size as numbers
        Collections.copy(copyList, numbers); // Now it will work
        System.out.println("Copied List: " + copyList);

        Collections.fill(copyList, 8); // Fill the list with 8
        System.out.println("Filled List: " + copyList);
    }
}
