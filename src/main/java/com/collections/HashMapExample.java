package com.collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<Integer, String> hashMap = new HashMap<>();

        // 1. put(K key, V value): Adds key-value pairs
        hashMap.put(1, "Apple");
        hashMap.put(2, "Banana");
        hashMap.put(3, "Cherry");
        System.out.println("HashMap after adding elements: " + hashMap);

        // 2. putIfAbsent(K key, V value): Adds a key-value pair only if the key is not present
        hashMap.putIfAbsent(4, "Date");
        System.out.println("HashMap after putIfAbsent: " + hashMap);

        // 3. get(Object key): Retrieves value for the given key
        System.out.println("Value for key 2: " + hashMap.get(2));

        // 4. remove(Object key): Removes the key-value pair
        hashMap.remove(3);
        System.out.println("HashMap after removing key 3: " + hashMap);

        // 5. containsKey(Object key): Checks if the key exists
        System.out.println("Contains key 1: " + hashMap.containsKey(1));

        // 6. containsValue(Object value): Checks if the value exists
        System.out.println("Contains value 'Banana': " + hashMap.containsValue("Banana"));

        // 7. keySet(): Retrieves all keys
        System.out.println("Keys in HashMap: " + hashMap.keySet());

        // 8. values(): Retrieves all values
        System.out.println("Values in HashMap: " + hashMap.values());

        // 9. entrySet(): Retrieves all key-value pairs
        for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }

        // 10. replace(K key, V value): Replaces the value for the given key
        hashMap.replace(1, "Apricot");
        System.out.println("HashMap after replacing value for key 1: " + hashMap);

        // 11. clear(): Removes all elements
        hashMap.clear();
        System.out.println("HashMap after clear: " + hashMap);
    }
}

