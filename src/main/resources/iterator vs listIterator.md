### Difference between Iterator and ListIterator


### Iterator

- works with List,Set and Map(entrySet).
- Traverses elements in one direction (forward only).
- hasNext(), next(), remove().
- Cannot add or modify elements while iterating.
- Starts from the first element only
- No index tracking.

***Example***
```
```

### ListIterator

- Works only with List (e.g., ArrayList, LinkedList).
- Traverses elements in both directions (forward & backward).
- hasNext(), next(), hasPrevious(), previous(), add(), set(), remove().
- Can add, modify (set), and remove elements while iterating.
- Can start from any position using listIterator(index).
- Provides index information via nextIndex() and previousIndex().

***Example**
```
```

### Difference between HashMap  and ConcurrentHashMap

### HashMap

- Not thread-safe.
- Poor performance in multi-threaded environments.
- Allows one null key and multiple null values.
- No locking mechanism.
- Fail-fast: Throws ConcurrentModificationException during concurrent modifications.
- Suitable for single-threaded applications.

***Example***

```
import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        try {
            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " => " + entry.getValue());
                map.put(4, "Four");  // Modifying during iteration
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("Exception: " + e);
        }
    }
}

o/p: 1 => One
Exception: java.util.ConcurrentModificationException
```

### ConcurrentHashMap

- Thread-safe for concurrent access.
- High performance in multi-threading due to internal locking.
- Does NOT allow null keys or null values.
- Uses segment-based locking (Java 7) or bucket-level locking (Java 8).
- Fail-safe: No exception; handles modifications gracefull
- Suitable for multi-threaded applications.

***Example***
```
`import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapExample {
    public static void main(String[] args) {
        Map<Integer, String> map = new ConcurrentHashMap<>();
        map.put(1, "One");
        map.put(2, "Two");
        map.put(3, "Three");

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " => " + entry.getValue());
            map.put(4, "Four");  // Modifying during iteration (No exception)
        }
    }
}

o/p:1 => One
2 => Two
3 => Three
4 => Four
```

***Note***
- Use ConcurrentHashMap in multi-threaded environments to avoid ConcurrentModificationException.

***For modifying collections during iteration, prefer***
- ConcurrentHashMap (for maps).
- CopyOnWriteArrayList (for lists).
- Iterator.remove() instead of modifying the collection directly.


### Create a treemap where key is Employee.

***Example**

```
import java.util.*;

class Employee implements Comparable<Employee> {
    int id;
    String name;
    double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Compare employees based on their ID
    @Override
    public int compareTo(Employee other) {
        return Integer.compare(this.id, other.id);
    }

    @Override
    public String toString() {
        return "Employee{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}

public class TreeMapExample {
    public static void main(String[] args) {
        // TreeMap with Employee as Key and Department as Value
        TreeMap<Employee, String> employeeMap = new TreeMap<>();

        // Adding Employees
        employeeMap.put(new Employee(102, "Alice", 75000), "HR");
        employeeMap.put(new Employee(101, "Bob", 85000), "IT");
        employeeMap.put(new Employee(103, "Charlie", 65000), "Finance");

        // Iterating over TreeMap
        for (Map.Entry<Employee, String> entry : employeeMap.entrySet()) {
            System.out.println(entry.getKey() + " => Department: " + entry.getValue());
        }
    }
}

o/p: Employee{id=101, name='Bob', salary=85000.0} => Department: IT
Employee{id=102, name='Alice', salary=75000.0} => Department: HR
Employee{id=103, name='Charlie', salary=65000.0} => Department: Finance


```

***Note***

- To use a custom class like Employee as the key in a TreeMap, the class must implement the Comparable interface (or you can provide a custom Comparator).
- This ensures that the TreeMap can sort the keys.
- ```compareTo() Method:``` This is required for sorting. We are sorting employees based on their ID.
- ```toString() Method:``` Makes it easier to print employee details.

### How Does This Work?

```Sorting:```
The ```TreeMap``` automatically sorts the keys (i.e., ```Employee``` objects) based on the ```compareTo()``` method in the ```Employee``` class.

- Since we compared using id, the employees are sorted in ascending order of IDs.

```Insertion:```
When inserting into the ```TreeMap```, Java uses the ```compareTo()``` method to determine where to place the key.

```Iteration:```
The ```entrySet()``` method returns the key-value pairs in sorted order.