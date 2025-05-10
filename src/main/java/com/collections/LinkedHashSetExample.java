package com.collections;

import java.util.LinkedHashSet;
import java.util.Iterator;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        // 1. Create a LinkedHashSet
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();

        // 2. add(E e): Adds elements to the LinkedHashSet
        linkedHashSet.add("Apple");
        linkedHashSet.add("Banana");
        linkedHashSet.add("Cherry");
        System.out.println("LinkedHashSet after adding elements: " + linkedHashSet);

        // 3. addAll(Collection<? extends E> c): Adds all elements from a collection
        LinkedHashSet<String> anotherSet = new LinkedHashSet<>();
        anotherSet.add("Date");
        anotherSet.add("Elderberry");
        linkedHashSet.addAll(anotherSet);
        System.out.println("LinkedHashSet after adding another collection: " + linkedHashSet);

        // 4. remove(Object o): Removes an element
        linkedHashSet.remove("Banana");
        System.out.println("LinkedHashSet after removing 'Banana': " + linkedHashSet);

        // 5. contains(Object o): Checks if an element exists
        System.out.println("LinkedHashSet contains 'Apple': " + linkedHashSet.contains("Apple"));
        System.out.println("LinkedHashSet contains 'Fig': " + linkedHashSet.contains("Fig"));

        // 6. size(): Returns the number of elements
        System.out.println("Size of LinkedHashSet: " + linkedHashSet.size());

        // 7. isEmpty(): Checks if the set is empty
        System.out.println("Is LinkedHashSet empty? " + linkedHashSet.isEmpty());

        // 8. iterator(): Iterate through the elements in insertion order
        System.out.println("Iterating over LinkedHashSet:");
        Iterator<String> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 9. toArray(): Converts LinkedHashSet to an array
        Object[] array = linkedHashSet.toArray();
        System.out.println("Array elements:");
        for (Object obj : array) {
            System.out.println(obj);
        }

        // 10. retainAll(Collection<?> c): Retains only common elements with another collection
        LinkedHashSet<String> retainSet = new LinkedHashSet<>();
        retainSet.add("Apple");
        retainSet.add("Date");
        linkedHashSet.retainAll(retainSet);
        System.out.println("LinkedHashSet after retainAll: " + linkedHashSet);

        // 11. clear(): Removes all elements
        linkedHashSet.clear();
        System.out.println("LinkedHashSet after clear: " + linkedHashSet);

        // 12. Check if LinkedHashSet is empty after clear
        System.out.println("Is LinkedHashSet empty after clear? " + linkedHashSet.isEmpty());
    }
}

