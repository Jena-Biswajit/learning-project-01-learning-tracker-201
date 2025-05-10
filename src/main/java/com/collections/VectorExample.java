package com.collections;

import java.util.Vector;

public class VectorExample {

    public static void main(String[] args) {
        // Create a Vector
        Vector<String> names = new Vector<>();
        Vector<Object> vector = null;
        names.add("biswajit");
        names.add("chandan");
        names.add(1, "saroj"); // Insert at index 1
        System.out.println(names); // Output: [biswajit, saroj, chandan]

        // Access an element
        System.out.println(names.get(0)); // Output: biswajit

        // Remove an element
        names.remove(1); // Removes element at index 1
        System.out.println(names); // Output: [biswajit, chandan]

        // Replace an element
        names.set(1, "saroj"); // Replace "chandan" with "saroj"
        System.out.println(names); // Output: [biswajit, saroj]

        // Check the size
        System.out.println(names.size()); // Output: 2

        // Check if an element exists
        System.out.println(names.contains("biswajit")); // Output: true

        // Check the capacity of the Vector

        System.out.println("Capacity: " + vector.capacity()); // Default capacity is 10

        // Check if the Vector contains an element
        System.out.println("Contains 'Cherry': " + vector.contains("Cherry")); // true
    }
}