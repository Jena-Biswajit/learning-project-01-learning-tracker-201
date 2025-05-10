package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // Using iterator to traverse the list
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();

            // Modifying the list during iteration
            if (item.equals("B")) {
//                list.add("E"); // Structural modification
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}

