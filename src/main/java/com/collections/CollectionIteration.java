package com.collections;

import java.util.*;

public class CollectionIteration {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println("For-Each Loop:");
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}
