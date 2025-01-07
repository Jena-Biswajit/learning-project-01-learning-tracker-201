### Collection Comparisons

### **1. ArrayList vs LinkedList**

| Feature                      | ArrayList                                  | LinkedList                                                     |
|------------------------------|--------------------------------------------|----------------------------------------------------------------|
| **Implementation**           | Resizable array                            | Doubly-linked list                                             |
| **Access Time**              | O(1) for random access (index-based)       | O(n) for random access                                         |
| **Insertion/Deletion**       | Slow for middle elements (O(n))            | Fast for middle elements (O(1) for add/remove at head or tail) |
| **Memory Usage**             | Less memory overhead                       | More memory overhead (due to pointers)                         |
| **Iteration Performance**    | Faster due to better cache locality        | Slower due to pointer chasing                                  |
| **Best Use Case**            | Frequent access to elements by index       | Frequent insertions/deletions                                  |

### Example:
```java
import java.util.ArrayList;
import java.util.LinkedList;

public class ListComparison {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();

        // Add elements
        arrayList.add(10);
        linkedList.add(10);

        System.out.println("ArrayList: " + arrayList);
        System.out.println("LinkedList: " + linkedList);
    }
}
```

---

## **2. ArrayList vs Vector**

| Feature                      | ArrayList                                  | Vector                                    |
|------------------------------|--------------------------------------------|-------------------------------------------|
| **Synchronization**          | Not synchronized (not thread-safe)         | Synchronized (thread-safe)                |
| **Performance**              | Faster in single-threaded environments     | Slower due to synchronization overhead    |
| **Growth Rate**              | Increases by 50% when full                 | Doubles in size when full                 |
| **Legacy or Modern**         | Part of modern Collections Framework       | Legacy class (before Java 2)              |
| **Best Use Case**            | When thread-safety is not required         | When thread-safety is required            |

### Example:
```java
import java.util.ArrayList;
import java.util.Vector;

public class ArrayListVsVector {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        Vector<String> vector = new Vector<>();

        arrayList.add("A");
        vector.add("A");

        System.out.println("ArrayList: " + arrayList);
        System.out.println("Vector: " + vector);
    }
}
```

---

## **3. Stack vs Queue**

| Feature                      | Stack                                   | Queue                                                                     |
|------------------------------|-----------------------------------------|---------------------------------------------------------------------------|
| **Order**                    | LIFO (Last In, First Out)               | FIFO (First In, First Out)                                                |
| **Implementation**           | Subclass of `Vector`                    | Interface in `java.util` (implemented by `LinkedList` or `PriorityQueue`) |
| **Common Methods**           | `push()`, `pop()`, `peek()`             | `add()`, `remove()`, `poll()`, `peek()`                                   |
| **Use Case**                 | Backtracking, undo operations           | Scheduling tasks, message queues                                          |

### Example:
```java
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

public class StackVsQueue {
    public static void main(String[] args) {
        // Stack Example
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        System.out.println("Stack Pop: " + stack.pop()); // Output: 2

        // Queue Example
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        System.out.println("Queue Poll: " + queue.poll()); // Output: 1
    }
}
```

---

## **4. HashSet vs LinkedHashSet vs TreeSet**

| Feature                      | HashSet                                | LinkedHashSet                            | TreeSet                                   |
|------------------------------|----------------------------------------|------------------------------------------|-------------------------------------------|
| **Order**                    | Unordered                              | Maintains insertion order                | Sorted order                              |
| **Implementation**           | Hash table                             | Hash table + Linked list                 | Red-black tree                            |
| **Null Values**              | Allows one `null` value                | Allows one `null` value                  | Does not allow `null` values              |
| **Performance**              | O(1) for add, remove, contains         | O(1) for add, remove, contains           | O(log n) for add, remove, contains        |
| **Best Use Case**            | Fast operations, no order required     | Maintain insertion order                 | Sorted set of elements                    |

### Example:
```java
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class SetComparison {
    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<>();
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        TreeSet<String> treeSet = new TreeSet<>();

        hashSet.add("B");
        hashSet.add("A");

        linkedHashSet.add("B");
        linkedHashSet.add("A");

        treeSet.add("B");
        treeSet.add("A");

        System.out.println("HashSet: " + hashSet); // Output: [A, B] or [B, A]
        System.out.println("LinkedHashSet: " + linkedHashSet); // Output: [B, A]
        System.out.println("TreeSet: " + treeSet); // Output: [A, B]
    }
}
```
