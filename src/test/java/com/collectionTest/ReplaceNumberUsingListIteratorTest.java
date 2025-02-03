package com.collectionTest;

import java.util.*;


/*   Replace any number divisible by 3 with -1.
     Add 0 before every even number.
*/

public class ReplaceNumberUsingListIteratorTest {
    public static void main(String[] args) {
        // Initialize a LinkedList with some numbers
        LinkedList<Integer> numbers = new LinkedList<>(Arrays.asList(5, 6, 9, 8, 12, 7));

        // Returns a fixed-size list backed by the specified array.
        // Changes made to the array will be visible in the returned list,
        // and changes made to the list will be visible in the array.
        // Arrays.asList()

        System.out.println("Original List: "+numbers);

        // Get a ListIterator for the LinkedList
        ListIterator<Integer> iterator = numbers.listIterator();

        // Traverse the list using the ListIterator
        while(iterator.hasNext())

        {
            int number = iterator.next();

            // Replace numbers divisible by 3 with -1
            if (number % 3 == 0) {
                iterator.set(-1);
            }

            // Add 0 before every even number
            if (number % 2 == 0) {
                iterator.previous(); // Move back one step
                iterator.add(0);     // Add 0 before the even number
                iterator.next();     // Move forward to skip the even number
            }
        }

        System.out.println("Modified List: "+numbers);
    }
}
