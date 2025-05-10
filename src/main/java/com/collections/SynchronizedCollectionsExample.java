package com.collections;
import java.util.*;

public class SynchronizedCollectionsExample {
    public static void main(String[] args) {
        // Synchronized List
        List<String> syncList = Collections.synchronizedList(new ArrayList<>());
        syncList.add("A");
        syncList.add("B");
        synchronized (syncList) {
            System.out.println("Synchronized List: " + syncList);
        }

        // Synchronized Set
        Set<String> syncSet = Collections.synchronizedSet(new HashSet<>());
        syncSet.add("X");
        syncSet.add("Y");
        synchronized (syncSet) {
            System.out.println("Synchronized Set: " + syncSet);
        }

        // Synchronized Map
        Map<String, String> syncMap = Collections.synchronizedMap(new HashMap<>());
        syncMap.put("Key1", "Value1");
        syncMap.put("Key2", "Value2");
        synchronized (syncMap) {
            System.out.println("Synchronized Map: " + syncMap);
        }
    }
}
