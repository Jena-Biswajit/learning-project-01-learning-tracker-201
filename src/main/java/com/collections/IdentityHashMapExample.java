package com.collections;
import java.util.IdentityHashMap;

public class IdentityHashMapExample {
    public static void main(String[] args) {
        IdentityHashMap<String,String> identityMap = new IdentityHashMap<>();
        // Two String objects with the same value but different memory references
        String key1 = new String("name");
        String key2 = new String("name");

        // Add both keys to IdentityHashMap
        identityMap.put(key1, "Biswa");
        identityMap.put(key2, "jit");

        // Print the map
        System.out.println("IdentityHashMap: " + identityMap);

        // Check the size of the map
        System.out.println("Size of IdentityHashMap: " + identityMap.size());
    }
}
