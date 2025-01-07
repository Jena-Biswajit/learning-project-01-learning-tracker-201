### Java Collections Framework
- In Java, the List, Set, and Map interfaces are part of the Java Collections Framework.
- Each provides methods to manipulate collections of objects but serves different purposes:

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

