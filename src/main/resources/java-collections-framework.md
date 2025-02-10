### Java Collections Framework
- In Java, the List, Set, and Map interfaces are part of the Java Collections Framework.
- Each provides methods to manipulate collections of objects but serves different purposes:

 ![Alt text](https://media.geeksforgeeks.org/wp-content/uploads/20240726145939/Collections-in-Java.png)

- **List:** Ordered collection that allows duplicates.
- **Set:** Unordered collection that does not allow duplicates.
- **Map:** Collection of key-value pairs where keys are unique.

### List Interface
- The List interface is part of the Java Collections Framework and is a subtype of the Collection interface.
- It represents an ordered collection of elements and allows duplicates. 
- The List interface provides positional access and insertion of elements, making it highly versatile for scenarios where maintaining the order of elements is essential.

**Characteristics of the List Interface:**

- **Order is Preserved:** Elements are maintained in the order they were inserted.

- **Allows Duplicates:** A List can contain multiple elements with the same value.

- **Indexed Access:** Elements can be accessed using their index, starting from 0.

- **Generic Support:** The List interface supports generics, allowing type-safe operations.

- **Supports Null:** Most List implementations allow null as an element.

### Common Implementations of the List Interface:
**ArrayList:** A resizable array-backed implementation.
- Best for random access and frequent read operations.
- Slower for insertions and deletions in the middle of the list.

**LinkedList:** A doubly-linked list implementation.
- Best for frequent insertions and deletions.
- Slower for random access.

**Vector:** A synchronized (thread-safe) version of ArrayList.
- Generally slower than ArrayList due to synchronization overhead.
- Stack: A subclass of Vector that implements a LIFO (Last-In-First-Out) stack.

**ArrayList**
- The ArrayList class is a part of the Java Collections Framework and implements the List interface.
- It is a dynamic array that can grow and shrink in size as needed.
- Unlike regular arrays, which have a fixed size, an ArrayList allows for more flexibility when working with collections of objects.

**Key Characteristics of ArrayList**
- **Resizable Array:** Automatically grows or shrinks as elements are added or removed.
- **Maintains Order:** Preserves the insertion order of elements.
- **Allows Duplicates:** An ArrayList can contain duplicate elements.
- **Indexed Access:** Provides fast, random access to elements using their index.
- **Supports Generics:** Can specify the type of elements stored, ensuring type safety.
- **Allows Null:** Can store null values.
- **Not Synchronized:** Not thread-safe by default (use Collections.synchronizedList for thread safety).

**Declaration and Initialization**
```java
import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        // Without Generics
        ArrayList list = new ArrayList();

        // With Generics (Type-Safe)
        ArrayList<String> stringList = new ArrayList<>();
        ArrayList<Integer> intList = new ArrayList<>();
    }
}
```

**constructor**
- ```ArrayList():``` Creates an empty list with an initial capacity of 10.
```java
ArrayList<String> list = new ArrayList<>();
```

- ```ArrayList(int initialCapacity):``` Creates an empty list with the specified initial capacity.
```java
ArrayList<String> list = new ArrayList<>(20); // Initial capacity of 20
```

- ```ArrayList(Collection<? extends E> c):``` Creates a list containing the elements of the specified collection.
```java
ArrayList<String> list = new ArrayList<>(Arrays.asList("Alice", "Bob"));
```

### LinkedList 
- The LinkedList class in Java is part of the Java Collections Framework and implements both the List and Deque interfaces.
- This makes it a versatile data structure that can be used as a list, stack, or queue.
- Unlike ArrayList, which is backed by a resizable array, LinkedList uses a doubly linked list structure to store elements.

**Key Characteristics of LinkedList**
- **Doubly Linked Structure:** Each element (node) contains a reference to the next and previous nodes.
- **Efficient Insertions/Deletions:** Adding or removing elements from the beginning or middle is efficient (O(1) or O(n) depending on the position).
- **Maintains Order:** Preserves the order of elements as they are added.
- **Allows Duplicates:** Can contain duplicate elements.
- **Supports Null:** Can store null values.
- **Implements Deque:** Can be used as a queue, stack, or deque (double-ended queue).
- **Not Synchronized:** Not thread-safe by default.

**Declaration and Initialization**
```java
import java.util.LinkedList;

public class LinkedListExample {
    public static void main(String[] args) {
        // Without Generics
        LinkedList list = new LinkedList();

        // With Generics (Type-Safe)
        LinkedList<String> stringList = new LinkedList<>();
        LinkedList<Integer> intList = new LinkedList<>();
    }
}
```

**Constructors**
- ```LinkedList():``` Creates an empty list.
```java
LinkedList<String> list = new LinkedList<>();
```

- ```LinkedList(Collection<? extends E> c):``` Creates a list containing the elements of the specified collection.
```java
LinkedList<String> list = new LinkedList<>(Arrays.asList("Alice", "Bob"));
```

### Note
***Understanding List<String> names = new ArrayList<>();Statement***

***1. List Interface:***

   List is a Java interface from the java.util package.
   It represents an ordered collection (also called a sequence) where:
   Duplicate elements are allowed.
   Elements are stored and accessed by their index.
   Common implementations of List include ArrayList, LinkedList, and Vector.

***2. Generics (<String>):***

   <String> specifies the type of elements this List will hold.
   Using generics ensures type safety, meaning this list can only store String objects.
   Without generics, the List would accept any object, which could lead to runtime errors.

***3. Object Instantiation (new ArrayList<>()):***

   ArrayList is a concrete class that implements the List interface.
   It uses a dynamic array to store elements.
   Key features of ArrayList:
   Resizable: Automatically expands as elements are added.
   Provides constant-time access (O(1)) for retrieving elements by index.
   Not synchronized: It is not thread-safe, unlike Vector.

***4. Type Inference (<>):***

   The diamond operator (<>) introduced in Java 7 allows the compiler to infer the generic type based on the variable declaration (List<String>).
   Instead of repeating <String> on both sides (new ArrayList<String>()), you can simplify it as new ArrayList<>().

#### How ArrayList Stores Data:
- Internally, ArrayList uses an array (Object[]).
- When you add elements, they are stored sequentially in this array.
- If the array’s capacity is exceeded, ArrayList creates a larger array (usually 50% larger) and copies the existing elements into it.

### Important Methods in the List Interface

**1. add(E element)**
- Adds an element to the list. Overloaded to support adding at a specific index.

**Example**
```java
import java.util.ArrayList;
import java.util.List;

public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("biswajit");
        names.add("chandan");
        names.add(1, "saroj"); // Insert "saroj" at index 1
        System.out.println(names); // Output: [biswajit, saroj, chandan]
    }
}
```

**2. get(int index)**
- Retrieves the element at the specified index.

**Example**
```java
public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("biswajit");
        names.add("chandan");
        System.out.println(names.get(1)); // Output: chandan
    }
}
```

**3. remove(int index) / remove(Object o)**
- Removes the element at the specified index or the first occurrence of the specified object.

**Example**
```java
public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("biswajit");
        names.add("chandan");
        names.remove(0); // Removes element at index 0
        System.out.println(names); // Output: [chandan]

        names.remove("chandan"); // Removes the element "chandan"
        System.out.println(names); // Output: []
    }
}
```

**4. set(int index, E element)**
- Replaces the element at the specified index with a new value.

**Example**
```java
public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("biswajit");
        names.add("chandan");
        names.set(1, "saroj"); // Replace "chandan" with "saroj"
        System.out.println(names); // Output: [biswajit, saroj]
    }
}
```

**5. indexOf(Object o)**
- Returns the index of the first occurrence of the specified element or -1 if not found.

**Example**
```java
public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("biswajit");
        names.add("chandan");
        System.out.println(names.indexOf("chandan")); // Output: 1
        System.out.println(names.indexOf("biswajit")); // Output: -1
    }
}
```

**6. subList(int fromIndex, int toIndex)**
- Returns a view of a portion of the list from fromIndex (inclusive) to toIndex (exclusive).

**Example**
```java
public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("biswajit");
        names.add("chandan");
        names.add("saroj");
        System.out.println(names.subList(1, 3)); // Output: [chandan, saroj]
    }
}
```

**7. contains(Object o)**
- Checks if the list contains the specified element.

**Example**
```java
public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("biswajit");
        System.out.println(names.contains("biswajit")); // Output: true
        System.out.println(names.contains("chandan")); // Output: false
    }
}
```

**8. size()**
- Returns the number of elements in the list.

**Example**
```java
public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("biswajit");
        names.add("chandan");
        System.out.println(names.size()); // Output: 2
    }
}
```

**9. isEmpty()**
- Checks if the list is empty.

**Example**
```java
public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        System.out.println(names.isEmpty()); // Output: true
        names.add("biswajit");
        System.out.println(names.isEmpty()); // Output: false
    }
}
```

**10. clear()**
- Removes all elements from the list.

**Example**
```java
public class ListExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("biswajit");
        names.add("chandan");
        names.clear();
        System.out.println(names); // Output: []
    }
}
```

### Stack
- The Stack class in Java is a part of the Java Collections Framework.
- It is a last-in, first-out (LIFO) data structure, where the last element added to the stack is the first one to be removed.
- The Stack class is an extension of the Vector class and implements the List interface.

**Key Characteristics of Stack**
- **LIFO Behavior:** Operates on the principle of "last in, first out."
- **Built on Vector:** Inherits properties and methods from the Vector class.
- **Thread-Safe:** Like Vector, Stack methods are synchronized.
- **Resizable:** Automatically grows as elements are added.
- **Contains Legacy Features:** Considered a legacy class; for modern use, Deque (e.g., ArrayDeque) is often preferred.

**Declaration and Initialization**
```java
import java.util.Stack;

public class StackExample {
    public static void main(String[] args) {
        // Creating a stack of integers
        Stack<Integer> stack = new Stack<>();
    }
}
```

**Constructors**
```java
Stack<String> stack = new Stack<>();
```

### Methods of Stack

**1. push(E item)**
- Adds an item to the top of the stack.
```java
Stack<String> stack = new Stack<>();
stack.push("Apple");
stack.push("Banana");
stack.push("Cherry");
System.out.println(stack); // Output: [Apple, Banana, Cherry]
```

**2. pop()**
- Removes and returns the item at the top of the stack.
- Throws EmptyStackException if the stack is empty.
```java
String topItem = stack.pop();
System.out.println(topItem); // Output: Cherry
System.out.println(stack);   // Output: [Apple, Banana]
```

**3. peek()**
- Returns the item at the top of the stack without removing it.
- Throws EmptyStackException if the stack is empty.
```java
String topItem = stack.peek();
System.out.println(topItem); // Output: Banana
System.out.println(stack);   // Output: [Apple, Banana]
```

**4. isEmpty()**
- Checks if the stack is empty.
```java
System.out.println(stack.isEmpty()); // Output: false
```

**5. search(Object o)**
- Returns the 1-based position of the element in the stack.
- If the element is not found, returns -1.
```java
int position = stack.search("Apple");
System.out.println(position); // Output: 2
```

**6. size()**
- Returns the number of elements in the stack.
```java
System.out.println(stack.size()); // Output: 2
```

**7. clear()**
- Removes all elements from the stack.
```java
stack.clear();
System.out.println(stack.isEmpty()); // Output: true
```

**8. toArray()**
- Converts the stack into an array.
```java
Object[] array = stack.toArray();
System.out.println(Arrays.toString(array)); // Output: [Apple, Banana]
```

### Vector
**Key Characteristics of Vector**
- **Dynamic Resizing:** Automatically resizes itself when more space is needed.
- **Thread-Safe:** Methods in Vector are synchronized, making it suitable for multi-threaded environments.
- **Random Access:** Provides constant time performance for accessing elements by index.
- **Legacy Class:** Introduced in Java 1.0, but still widely used due to backward compatibility.

**Declaration and Initialization**
```java
import java.util.Vector;
public class VectorExample {
public static void main(String[] args) {
       // Creating a vector of strings
      Vector<String> vector = new Vector<>();
    }
}
```

**Constructors**
- ```Vector():``` Creates an empty vector with an initial capacity of 10.
```java
Vector<String> vector = new Vector<>();
Vector(int initialCapacity): Creates a vector with the specified initial capacity.
```

### Common Methods of Vector
**1. add(E e)**
- Adds an element to the vector.
```java
Vector<String> vector = new Vector<>();
vector.add("Apple");
vector.add("Banana");
System.out.println(vector); // Output: [Apple, Banana]
```

**2. add(int index, E element)**
- Inserts an element at the specified position.
```java
vector.add(1, "Cherry");
System.out.println(vector); // Output: [Apple, Cherry, Banana]
```

**3. get(int index)**
- Retrieves the element at the specified position.
```java
String item = vector.get(1);
System.out.println(item); // Output: Cherry
```

**4. set(int index, E element)**
- Replaces the element at the specified position with the given element.
```java
vector.set(1, "Grape");
System.out.println(vector); // Output: [Apple, Grape, Banana]
```

**5. remove(int index)**
- Removes the element at the specified position.
```java
vector.remove(1);
System.out.println(vector); // Output: [Apple, Banana]
```

**6. remove(Object o)**
- Removes the first occurrence of the specified element.
```java
vector.remove("Apple");
System.out.println(vector); // Output: [Banana]
```

**7. size()**
- Returns the number of elements in the vector.
```java
System.out.println(vector.size()); // Output: 1
```

**8. isEmpty()**
- Checks if the vector is empty.
```java
System.out.println(vector.isEmpty()); // Output: false
```

**9. contains(Object o)**
- Checks if the vector contains the specified element.
```java
System.out.println(vector.contains("Banana")); // Output: true
```

**10. clear()**
- Removes all elements from the vector.
```java
vector.clear();
System.out.println(vector.isEmpty()); // Output: true
```

### Set Interface 
- The Set interface in Java is a part of the Java Collections Framework and extends the Collection interface. 
- A Set is a collection that does not allow duplicate elements.
- It is ideal for scenarios where you need to maintain a unique collection of objects.

**Key Characteristics of the Set Interface**
- **No Duplicate Elements:** A Set does not allow duplicate entries. If you try to add a duplicate, the existing element remains unchanged.
- **Unordered:** Elements in a Set are not stored in a specific order (though some implementations like LinkedHashSet preserve insertion order).
- **Null Values:** A Set can contain at most one null value.
- **No Indexing:** Unlike lists, elements in a Set cannot be accessed by an index.

**Common Implementations:**
- **HashSet:** Backed by a hash table, does not guarantee order.
- **LinkedHashSet:** Maintains insertion order.
- **TreeSet:** Implements a sorted set using a red-black tree.

**Declaration and Initialization**
```java
import java.util.*;

public class SetExample {
    public static void main(String[] args) {
        // Creating a HashSet
        Set<String> set = new HashSet<>();

        // Creating a LinkedHashSet
        Set<Integer> linkedSet = new LinkedHashSet<>();

        // Creating a TreeSet
        Set<Double> treeSet = new TreeSet<>();
    }
}
```

**1. HashSet**
- Backed by a hash table.
- Does not maintain any order of elements.
- Best for performance (O(1) for most operations).
   
**Example:**
```java
Set<Integer> hashSet = new HashSet<>();
hashSet.add(10);
hashSet.add(20);
hashSet.add(10); // Duplicate
System.out.println(hashSet); // Output: [20, 10]
```

**2. LinkedHashSet**
- Backed by a hash table and linked list.
- Maintains the insertion order.
- Slightly slower than HashSet.

**Example:**
```java
Set<Integer> linkedSet = new LinkedHashSet<>();
linkedSet.add(10);
linkedSet.add(20);
linkedSet.add(30);
System.out.println(linkedSet); // Output: [10, 20, 30]
```

**3. TreeSet**
- Backed by a red-black tree.
- Maintains elements in sorted order.
- Does not allow null elements.
   
**Example:**
```java
Set<Integer> treeSet = new TreeSet<>();
treeSet.add(30);
treeSet.add(10);
treeSet.add(20);
System.out.println(treeSet); // Output: [10, 20, 30]
```

### Common Methods of the Set Interface
** add(E e)**
- Adds an element to the set if it is not already present.
```
Set<String> set = new HashSet<>();
set.add("Apple");
set.add("Banana");
set.add("Apple"); // Duplicate, ignored
System.out.println(set); // Output: [Apple, Banana]
```

**retainAll(Collection<?> c)**
- Keeps only the elements in the set that are contained in the specified collection.
```
Set<String> common = new HashSet<>(Arrays.asList("Apple", "Cherry"));
set.retainAll(common);
System.out.println(set); // Output: [Apple, Cherry]
```

**removeAll(Collection<?> c)**
- Removes all elements in the set that are also contained in the specified collection.
```
set.removeAll(common);
System.out.println(set); // Output: []
```

**iterator()**
- Returns an iterator over the elements in the set.
```
Iterator<String> iterator = set.iterator();
while (iterator.hasNext()) {
    System.out.println(iterator.next());
}
```

### Map Interface
- A Map stores key-value pairs. Keys are unique, but values can be duplicated. 
- Common implementations: ```HashMap```, ```TreeMap```, ```LinkedHashMap.```

**Methods**

- **put(K key, V value)**
- Inserts a key-value pair into the map.
```java
import java.util.Map;
import java.util.HashMap;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        System.out.println(map); // Output: {1=One, 2=Two}
    }
}
```

**get(Object key)**
- Retrieves the value associated with the specified key.
```
public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        System.out.println(map.get(1)); // Output: One
    }
}
```

**remove(Object key)**
- Removes the entry for the specified key.
```
public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.remove(1);
        System.out.println(map); // Output: {}
    }
}
```

**containsKey(Object key)**
- Checks if the map contains the specified key.
```
public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        System.out.println(map.containsKey(1)); // Output: true
    }
}
```

**keySet()**
- Returns a Set view of the keys in the map.
```
public class MapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        System.out.println(map.keySet()); // Output: [1, 2]
    }
}
```

