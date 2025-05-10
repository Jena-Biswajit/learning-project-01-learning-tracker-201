package com.collections;
import java.util.WeakHashMap;
public class WeakHashMapExample {

    // Custom class to override finalize
    static class Key {
        private String name;

        public Key(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        protected void finalize()  {
            System.out.println("Finalizing Key: " + name);
        }
    }

    public static void main(String[] args) {
        WeakHashMap<Key, String> weakMap = new WeakHashMap<>();

        // Two keys created as new Key objects
        Key key1 = new Key("name");
        Key key2 = new Key("surName");

        // Add both keys to WeakHashMap
        weakMap.put(key1, "Biswajit");
        weakMap.put(key2, "jena");

        // Print the map before garbage collection
        System.out.println("Before GC: " + weakMap);

        // Nullify one key to make it eligible for garbage collection
        key2 = null;

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

