package com.collections;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        // Example 1: Add elements
        List<String> names = new LinkedList<>();
        names.add("biswajit");
        names.add("chandan");
        names.add(1, "saroj"); // Insert "saroj" at index 1
        System.out.println(names); // Output: [biswajit, saroj, chandan]

        // Example 2: Get an element
        List<String> name1 = new LinkedList<>();
        name1.add("biswajit");
        name1.add("chandan");
        System.out.println(name1.get(1)); // Output: chandan

        // Example 3: Remove elements
        List<String> name2 = new LinkedList<>();
        name2.add("biswajit");
        name2.add("chandan");
        name2.remove(0); // Removes element at index 0
        System.out.println(name2); // Output: [chandan]

        name2.remove("chandan"); // Removes the element "chandan"
        System.out.println(name2); // Output: []

        // Example 4: Replace an element
        List<String> name3 = new LinkedList<>();
        name3.add("biswajit");
        name3.add("chandan");
        name3.set(1, "saroj"); // Replace "chandan" with "saroj"
        System.out.println(name3); // Output: [biswajit, saroj]

        // Example 5: Find index of an element
        List<String> name4 = new LinkedList<>();
        name4.add("biswajit");
        name4.add("chandan");
        System.out.println(name4.indexOf("chandan")); // Output: 1
        System.out.println(name4.indexOf("saroj")); // Output: -1

        // Example 6: Sublist of elements
        List<String> name5 = new LinkedList<>();
        name5.add("biswajit");
        name5.add("chandan");
        name5.add("saroj");
        System.out.println(name5.subList(1, 3)); // Output: [chandan, saroj]

        // Example 7: Check if a list contains an element
        List<String> name6 = new LinkedList<>();
        name6.add("biswajit");
        System.out.println(name6.contains("biswajit")); // Output: true
        System.out.println(name6.contains("chandan")); // Output: false

        // Example 8: Get the size of the list
        List<String> name7 = new LinkedList<>();
        name7.add("biswajit");
        name7.add("chandan");
        System.out.println(name7.size()); // Output: 2

        // Example 9: Check if the list is empty
        List<String> name8 = new LinkedList<>();
        System.out.println(name8.isEmpty()); // Output: true
        name8.add("biswajit");
        System.out.println(name8.isEmpty()); // Output: false

        // Example 10: Clear all elements from the list
        List<String> name9 = new LinkedList<>();
        name9.add("biswajit");
        name9.add("chandan");
        name9.clear();
        System.out.println(name9); // Output: []
    }
}
