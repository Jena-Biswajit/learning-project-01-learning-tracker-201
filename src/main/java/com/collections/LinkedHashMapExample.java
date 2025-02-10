package com.collections;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        // Create a LinkedHashMap
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();

        // 1. put(K key, V value): Adds key-value pairs
        linkedHashMap.put(1, "Apple");
        linkedHashMap.put(2, "Banana");
        linkedHashMap.put(3, "Cherry");
        System.out.println("LinkedHashMap after adding elements: " + linkedHashMap);

        // 2. get(Object key): Retrieves value for the given key
        System.out.println("Value for key 2: " + linkedHashMap.get(2));

        // 3. remove(Object key): Removes the key-value pair
        linkedHashMap.remove(3);
        System.out.println("LinkedHashMap after removing key 3: " + linkedHashMap);

        // 4. containsKey(Object key): Checks if the key exists
        System.out.println("Contains key 1: " + linkedHashMap.containsKey(1));

        // 5. containsValue(Object value): Checks if the value exists
        System.out.println("Contains value 'Banana': " + linkedHashMap.containsValue("Banana"));

        // 6. keySet(): Retrieves all keys
        System.out.println("Keys in LinkedHashMap: " + linkedHashMap.keySet());

        // 7. values(): Retrieves all values
        System.out.println("Values in LinkedHashMap: " + linkedHashMap.values());

        // 8. entrySet(): Retrieves all key-value pairs
        for (Map.Entry<Integer, String> entry : linkedHashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 9. replace(K key, V value): Replaces the value for the given key
        linkedHashMap.replace(1, "Apricot");
        System.out.println("LinkedHashMap after replacing value for key 1: " + linkedHashMap);

        // 10. clear(): Removes all elements
        linkedHashMap.clear();
        System.out.println("LinkedHashMap after clear: " + linkedHashMap);
    }
}
