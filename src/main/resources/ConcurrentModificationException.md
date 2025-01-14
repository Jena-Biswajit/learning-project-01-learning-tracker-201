### ConcurrentModificationException

- it is basically a runtime exception warning 
- The ConcurrentModificationException in Java occurs when you modify a collection (like ArrayList, HashSet, etc.) while iterating over it using an iterator or enhanced for loop.
- This exception is primarily thrown by fail-fast iterators when they detect structural modifications in the collection after the iterator is created.

**Cause**
- The iterator detects a structural modification to the collection (list.add("D")) during iteration.
- Fail-fast behavior in ArrayList's iterator checks for concurrent modification using a modCount variable.
- If modCount changes after the iterator is created, it throws ConcurrentModificationException.

**It happens when:**
- You're looping through a collection like an ArrayList or HashSet.
- You try to change (add/remove) items in the collection during the loop.

**Example**
```java
package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // Using iterator to traverse the list
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();

            // Modifying the list during iteration
            if (item.equals("B")) {
                list.add("E"); // Structural modification
              
            }
        }
        System.out.println(list);
    }
}
```


### Fixing ConcurrentModificationException
**Option 1:** Use Iterator's remove Method
- Instead of directly modifying the collection, use the iterator's remove method to safely remove elements.

**Example**
```java
package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationException {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");

        // Using iterator to traverse the list
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();

            // Modifying the list during iteration
            if (item.equals("B")) {
//                list.add("E"); // Structural modification
                iterator.remove();
            }
        }
        System.out.println(list);
    }
}
```