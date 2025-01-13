package com.collections;

import java.util.*;

public class CollectionIteration {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println("For-Each Loop:");
        for (String fruit : list) {
            System.out.println(fruit);
        }

        // 1. For loop with index (for list type)
        System.out.println("\nUsing For loop with index:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        // 2. Using Iterator
        System.out.println("\nUsing Iterator:");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // 3. Using ListIterator
        System.out.println("\nUsing ListIterator:");
        ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        // 4. Using Enumeration
        System.out.println("\nUsing Enumeration:");
        Enumeration<String> enumeration = Collections.enumeration(list);
        while (enumeration.hasMoreElements()) {
            System.out.println(enumeration.nextElement());
        }
    }
}
