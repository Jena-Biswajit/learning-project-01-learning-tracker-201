package com.collections;
import java.util.concurrent.*;

public class ConcurrentCollectionsExample {
    public static void main(String[] args) {
        // Concurrent List
        CopyOnWriteArrayList<String> concurrentList = new CopyOnWriteArrayList<>();
        concurrentList.add("A");
        concurrentList.add("B");
        System.out.println("Concurrent List: " + concurrentList);

        // Concurrent Set
        CopyOnWriteArraySet<String> concurrentSet = new CopyOnWriteArraySet<>();
        concurrentSet.add("X");
        concurrentSet.add("Y");
        System.out.println("Concurrent Set: " + concurrentSet);

        // Concurrent Map
        ConcurrentHashMap<String, String> concurrentMap = new ConcurrentHashMap<>();
        concurrentMap.put("Key1", "Value1");
        concurrentMap.put("Key2", "Value2");
        System.out.println("Concurrent Map: " + concurrentMap);
    }
}
