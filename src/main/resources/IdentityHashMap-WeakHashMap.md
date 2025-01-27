### Indentity HashMap
- The IdentityHashMap implements Map interface using Hashtable, using reference-equality in place of object-equality when comparing keys (and values). 
- It follows reference equality, instead of using the equals() method it uses the == operator.
- It is not synchronized and must be synchronized externally.
- Iterators are fail-fast, throw ConcurrentModificationException in an attempt to modify while iterating.
- IdentityHashMap doesn’t use hashCode() method instead it uses System.identityHashCode() method.
- Faster lookups: Since IdentityHashMap uses reference-equality for comparison, it is faster for lookups compared to HashMap which uses object-equality.
- Useful for comparing object instances: IdentityHashMap is useful in situations where you want to compare object instances rather than object values.
- Uses more memory: IdentityHashMap uses more memory compared to HashMap as it needs to store the reference to the object.

***Example***
```java
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

//0/p :IdentityHashMap: {name=Biswa, name=jit}
//        Size of IdentityHashMap: 2
```

# Methods of IdentityHashMap

### Key Terms
- **K**: The type of the keys in the map.
- **V**: The type of values mapped in the map.

---

### Methods and Descriptions

| **Method**                                | **Description**                                                                                           |
|-------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| `clear()`                                 | Removes all of the mappings from this map.                                                               |
| `clone()`                                 | Returns a shallow copy of this identity hash map: the keys and values themselves are not cloned.         |
| `containsKey(Object key)`                 | Tests whether the specified object reference is a key in this identity hash map.                        |
| `containsValue(Object value)`             | Tests whether the specified object reference is a value in this identity hash map.                      |
| `entrySet()`                              | Returns a `Set` view of the mappings contained in this map.                                              |
| `equals(Object o)`                        | Compares the specified object with this map for equality.                                                |
| `get(Object key)`                         | Returns the value to which the specified key is mapped, or `null` if this map contains no mapping.      |
| `hashCode()`                              | Returns the hash code value for this map.                                                                |
| `isEmpty()`                               | Returns `true` if this identity hash map contains no key-value mappings.                                |
| `keySet()`                                | Returns an identity-based set view of the keys contained in this map.                                   |
| `put(K key, V value)`                     | Associates the specified value with the specified key in this identity hash map.                        |
| `putAll(Map<? extends K, ? extends V> m)` | Copies all of the mappings from the specified map to this map.                                      |
| `remove(Object key)`                      | Removes the mapping for this key from this map if present.                                               |
| `size()`                                  | Returns the number of key-value mappings in this identity hash map.                                     |
| `values()`                                | Returns a `Collection` view of the values contained in this map.                                        |

---

### Notes
- **IdentityHashMap** uses reference equality (`==`) instead of object equality (`equals()`) to compare keys.
- It is part of the `java.util` package and is useful when reference equality is desired.

### Weak HashMap
- if the object is specified as the key doesn’t contain any references- it is eligible for garbage collection even though it is associated with WeakHashMap.
- i.e Garbage Collector dominates over WeakHashMap.
- WeakHashMap is the Hash table-based implementation of the Map interface, with weak keys. An entry in a WeakHashMap will automatically be removed when its key is no longer in ordinary use.
- More precisely, the presence of a mapping for a given key will not prevent the key from being discarded by the garbage collector, that is, made finalizable, finalized, and then reclaimed. 
- When a key has been discarded its entry is effectively removed from the map, so this class behaves somewhat differently from other Map implementations.

***Example***
```java
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
//Before GC: {surName=jena, name=Biswajit}
//Finalizing Key: surName
//After GC: {name=Biswajit}
```