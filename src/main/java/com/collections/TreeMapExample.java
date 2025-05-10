package com.collections;

import java.util.TreeMap;
import java.util.Map;

public class TreeMapExample {
    public static void main(String[] args) {
        // Create a TreeMap
        TreeMap<Integer, String> treeMap = new TreeMap<>();

        // 1. put(K key, V value): Adds key-value pairs (sorted by keys)
        treeMap.put(3, "Cherry");
        treeMap.put(1, "Apple");
        treeMap.put(2, "Banana");
        System.out.println("TreeMap after adding elements: " + treeMap);

        // 2. get(Object key): Retrieves value for the given key
        System.out.println("Value for key 2: " + treeMap.get(2));

        // 3. remove(Object key): Removes the key-value pair
        treeMap.remove(3);
        System.out.println("TreeMap after removing key 3: " + treeMap);

        // 4. firstKey(): Retrieves the first (lowest) key
        System.out.println("First key: " + treeMap.firstKey());

        // 5. lastKey(): Retrieves the last (highest) key
        System.out.println("Last key: " + treeMap.lastKey());

        // 6. headMap(K toKey): Retrieves entries with keys less than the given key
        System.out.println("HeadMap (less than 2): " + treeMap.headMap(2));

        // 7. tailMap(K fromKey): Retrieves entries with keys greater than or equal to the given key
        System.out.println("TailMap (from 2): " + treeMap.tailMap(2));

        // 8. subMap(K fromKey, K toKey): Retrieves entries in a range
        System.out.println("SubMap (from 1 to 3): " + treeMap.subMap(1, 3));

        // 9. entrySet(): Retrieves all key-value pairs
        for (Map.Entry<Integer, String> entry : treeMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 10. clear(): Removes all elements
        treeMap.clear();
        System.out.println("TreeMap after clear: " + treeMap);
    }
}
