package com.collections;
import java.util.*;

public class ImmutableCollectionsExample {
    public static void main(String[] args) {
        // Immutable List
        List<String> immutableList = List.of("A", "B", "C");
        System.out.println("Immutable List: " + immutableList);

        // Immutable Set
        Set<String> immutableSet = Set.of("X", "Y", "Z");
        System.out.println("Immutable Set: " + immutableSet);

        // Immutable Map
        Map<String, String> immutableMap = Map.of(
                "Key1", "Value1",
                "Key2", "Value2"
        );
        System.out.println("Immutable Map: " + immutableMap);

        // Uncommenting below lines will throw UnsupportedOperationException
        // immutableList.add("D");
        // immutableSet.add("W");
        // immutableMap.put("Key3"
    }
}
