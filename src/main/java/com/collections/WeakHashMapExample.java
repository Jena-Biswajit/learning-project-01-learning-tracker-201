package com.collections;
import java.util.WeakHashMap;
public class WeakHashMapExample {
    public static void main(String[] args) {
        WeakHashMap<String, String> weakMap = new WeakHashMap<>();

        // Two keys created as new String objects
        String name = new String("name");
        String surName = new String("surName");

        // Add both keys to WeakHashMap
        weakMap.put(name, "Biswajit");
        weakMap.put(surName, "jena");

        // Print the map before garbage collection
        System.out.println("Before GC: " + weakMap);

        // Nullify one key to make it eligible for garbage collection
        surName = null;

        // Trigger garbage collection
        System.gc();

        // Wait for GC to process
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print the map after garbage collection
        System.out.println("After GC: " + weakMap);
    }
}

