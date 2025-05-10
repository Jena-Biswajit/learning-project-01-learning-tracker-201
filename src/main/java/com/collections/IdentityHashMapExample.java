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

        //o/p is name=Biswa, name=jit because IdentityHashMap uses (==) operator to compare
        // keys so it will take duplicate as also a key

        // Note : HashMap by default uses equals() to compare keys which is compared it's value
        // whether in IdentityHashMap it is comparing using (==) operator which is compared it's
        // reference or address which is different for both the keys that's even both are equal
        // HashMap taking both the input as keys

        // Check the size of the map
        System.out.println("Size of IdentityHashMap: " + identityMap.size());
    }
}
