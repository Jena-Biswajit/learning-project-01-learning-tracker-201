package com.collections;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetExample {
    public static void main(String[] args) {
        // 1. Create a HashSet
        HashSet<String> hashSet = new HashSet<>();

        // 2. add(E e): Adds elements to the HashSet
        hashSet.add("Apple");
        hashSet.add("Banana");
        hashSet.add("Cherry");
        System.out.println("HashSet after adding elements: " + hashSet);

        // 3. addAll(Collection<? extends E> c): Adds all elements from a collection
        HashSet<String> anotherSet = new HashSet<>();
        anotherSet.add("Date");
        anotherSet.add("Elderberry");
        hashSet.addAll(anotherSet);
        System.out.println("HashSet after adding another collection: " + hashSet);

        // 4. remove(Object o): Removes an element
        hashSet.remove("Banana");
        System.out.println("HashSet after removing 'Banana': " + hashSet);

        // 5. contains(Object o): Checks if an element exists
        System.out.println("HashSet contains 'Apple': " + hashSet.contains("Apple"));
        System.out.println("HashSet contains 'Fig': " + hashSet.contains("Fig"));

        // 6. size(): Returns the number of elements
        System.out.println("Size of HashSet: " + hashSet.size());

        // 7. isEmpty(): Checks if the set is empty
        System.out.println("Is HashSet empty? " + hashSet.isEmpty());

        // 8. iterator(): Iterate through the elements
        System.out.println("Iterating over HashSet:");
        Iterator<String> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 9. toArray(): Converts HashSet to an array
        Object[] array = hashSet.toArray();
        System.out.println("Array elements:");
        for (Object obj : array) {
            System.out.println(obj);
        }

        // 10. retainAll(Collection<?> c): Retains only common elements with another collection
        HashSet<String> retainSet = new HashSet<>();
        retainSet.add("Apple");
        retainSet.add("Date");
        hashSet.retainAll(retainSet);
        System.out.println("HashSet after retainAll: " + hashSet);

        // 11. clear(): Removes all elements
        hashSet.clear();
        System.out.println("HashSet after clear: " + hashSet);

        // 12. Check if HashSet is empty after clear
        System.out.println("Is HashSet empty after clear? " + hashSet.isEmpty());
    }
}

