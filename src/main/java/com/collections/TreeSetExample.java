package com.collections;

import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetExample {
    public static void main(String[] args) {
        // 1. Create a TreeSet
        TreeSet<String> treeSet = new TreeSet<>();

        // 2. add(E e): Adds elements to the TreeSet
        treeSet.add("Banana");
        treeSet.add("Apple");
        treeSet.add("Cherry");
        System.out.println("TreeSet after adding elements: " + treeSet); // Sorted order

        // 3. addAll(Collection<? extends E> c): Adds all elements from a collection
        TreeSet<String> anotherSet = new TreeSet<>();
        anotherSet.add("Date");
        anotherSet.add("Elderberry");
        treeSet.addAll(anotherSet);
        System.out.println("TreeSet after adding another collection: " + treeSet);

        // 4. remove(Object o): Removes an element
        treeSet.remove("Banana");
        System.out.println("TreeSet after removing 'Banana': " + treeSet);

        // 5. contains(Object o): Checks if an element exists
        System.out.println("TreeSet contains 'Apple': " + treeSet.contains("Apple"));
        System.out.println("TreeSet contains 'Fig': " + treeSet.contains("Fig"));

        // 6. size(): Returns the number of elements
        System.out.println("Size of TreeSet: " + treeSet.size());

        // 7. isEmpty(): Checks if the set is empty
        System.out.println("Is TreeSet empty? " + treeSet.isEmpty());

        // 8. iterator(): Iterate through the elements in natural (sorted) order
        System.out.println("Iterating over TreeSet:");
        Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 9. toArray(): Converts TreeSet to an array
        Object[] array = treeSet.toArray();
        System.out.println("Array elements:");
        for (Object obj : array) {
            System.out.println(obj);
        }

        // 10. first(): Retrieves the first (lowest) element
        System.out.println("First element: " + treeSet.first());

        // 11. last(): Retrieves the last (highest) element
        System.out.println("Last element: " + treeSet.last());

        // 12. higher(E e): Returns the smallest element greater than the given element
        System.out.println("Element higher than 'Cherry': " + treeSet.higher("Cherry"));

        // 13. lower(E e): Returns the largest element smaller than the given element
        System.out.println("Element lower than 'Cherry': " + treeSet.lower("Cherry"));

        // 14. headSet(E toElement): Returns elements less than the given element
        System.out.println("HeadSet (less than 'Date'): " + treeSet.headSet("Date"));

        // 15. tailSet(E fromElement): Returns elements greater than or equal to the given element
        System.out.println("TailSet (greater than or equal to 'Cherry'): " + treeSet.tailSet("Cherry"));

        // 16. subSet(E fromElement, E toElement): Returns elements in a range
        System.out.println("Subset (from 'Apple' to 'Date'): " + treeSet.subSet("Apple", "Date"));

        // 17. descendingSet(): Returns elements in reverse order
        System.out.println("Descending TreeSet: " + treeSet.descendingSet());

        // 18. pollFirst(): Retrieves and removes the first (lowest) element
        System.out.println("Poll first element: " + treeSet.pollFirst());
        System.out.println("TreeSet after pollFirst: " + treeSet);

        // 19. pollLast(): Retrieves and removes the last (highest) element
        System.out.println("Poll last element: " + treeSet.pollLast());
        System.out.println("TreeSet after pollLast: " + treeSet);

        // 20. clear(): Removes all elements
        treeSet.clear();
        System.out.println("TreeSet after clear: " + treeSet);

        // 21. isEmpty() after clear
        System.out.println("Is TreeSet empty after clear? " + treeSet.isEmpty());
    }
}

