### Comparator:
- **Comparator :** is an interface used to define custom sorting logic outside of the class.
- **Purpose:** Allows different sorting criteria without modifying the class definition.
- Passed as an argument to sorting methods like Arrays.sort().

**Example**
```java
package com.arrays;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        // Array of numbers
        Integer[] numbers = {42, 15, 8, 23, 91, 16}; // Use Integer (not int) for Comparator

        // Sort in descending order using Comparator
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer num1, Integer num2) {
                return num2 - num1; // Descending order
            }
        });

        // Print the sorted array
        System.out.println("Sorted array in descending order:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
```
### Comparable:
- **Comparable** is an interface used to define a natural sorting order within the class itself.
- **Purpose:** Allows an object to be compared with another object of the same type using compareTo.
- Where Used: Automatically used when calling Arrays.sort() on an array of objects that implement Comparable.

**Example**
```java
package com.arrays;

import java.util.Arrays;

class Number implements Comparable<Number> {
    int value;

    // Constructor
    public Number(int value) {
        this.value = value;
    }

    // Sorting logic for descending order
    @Override
    public int compareTo(Number other) {
        return other.value - this.value; // Descending order
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        // Array of Number objects
        Number[] numbers = {
                new Number(42),
                new Number(15),
                new Number(8),
                new Number(23),
                new Number(91),
                new Number(16)
        };

        // Sort the array using Comparable
        Arrays.sort(numbers);

        // Print the sorted array
        System.out.println("Sorted array in descending order:");
        for (Number num : numbers) {
            System.out.print(num.value + " "); // Accessing the value directly
        }
    }
}
```
### Arrays.sort():
- **Definition:** A utility method provided by Java's Arrays class to sort arrays.
- **For primitive types (e.g., int[])**, it sorts directly in ascending order.
- **For objects**, it relies on either Comparable (natural order) or Comparator (custom order).

**Example**
```java
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Array of numbers
        int[] numbers = {42, 15, 8, 23, 91, 16};

        // Sort the array in ascending order
        Arrays.sort(numbers);

        // Print the sorted array
        System.out.println("Sorted array:");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
    }
}
```
### Integer vs int:

- int is a primitive type, and Integer is its wrapper class.
- Comparator and Comparable work with objects, so if you're sorting primitive arrays (int[]), you need to convert them to their wrapper (Integer[]) using Arrays.stream(array).boxed().

### compareTo Method:
- Defined in the Comparable interface.
- Used to define natural ordering for a class.
- **Returns:**
- A negative number if this is smaller than the other object.
- Zero if both are equal.
- A positive number if this is greater than the other object.

### compare Method:
- Defined in the Comparator interface.
- Used to define custom sorting criteria.
- Returns values similar to compareTo.
