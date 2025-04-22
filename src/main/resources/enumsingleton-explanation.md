### Understanding Enum-based Singleton in Java

```java
public enum EnumSingleton {
    INSTANCE;

    public void showMessage() {
        System.out.println("Hello from Enum Singleton!");
    }
}
```

---

- This tiny enum block handles **thread safety**, **serialization**, **reflection protection**, and **simplicity** without any extra code.

---

### 1.  Thread-safe by Default

### Why?
Java ensures that enum constants are created only once and in a thread-safe manner during **class loading**.

### How?
- JVM loads the enum class only once per `ClassLoader`.
- The `INSTANCE` is created as part of class initialization.
- No race conditions or double-checked locking needed.

```
EnumSingleton instance1 = EnumSingleton.INSTANCE;
EnumSingleton instance2 = EnumSingleton.INSTANCE;
System.out.println(instance1 == instance2); // true
```

---

### 2.  Serialization-safe by Default

### Why?
Enum implements special handling internally to return the same object during deserialization.

### Traditional Singleton Issue:
```
ObjectInputStream ois = new ObjectInputStream(...);
Singleton s2 = (Singleton) ois.readObject(); // creates a new instance unless readResolve() is used
```

### But in Enum:
```
EnumSingleton deserialized = (EnumSingleton) ois.readObject();
System.out.println(deserialized == EnumSingleton.INSTANCE); // 
```

> JVM guarantees that deserialization of an enum returns the **same constant**.


### 4. Cleaner Syntax

### Traditional Singleton:
- Needs: private constructor, static instance, `getInstance()`, sync blocks, readResolve...

### Enum Singleton:
- Needs only this:
```java
public enum EnumSingleton {
    INSTANCE;
}
```

---

### Summary Table

| Feature                  | Enum Singleton | Classic Singleton     |
|--------------------------|----------------|-----------------------|
| Thread-safe              | Yes            | Needs handling        |
| Serialization-safe       | Yes            | Needs `readResolve()` |
| Reflection-safe          | Yes            | Needs defense         |
| Code Complexity          | Low            | High                  |
| Syntax Simplicity        | Very simple    | Verbose               |

---


**Example**

```java
package com.example.singleton.enumbased;

public enum EnumSingleton {
    INSTANCE; // This is the singleton instance

    // You can define methods here
    public void showMessage() {
        System.out.println("Hello from Enum Singleton!");
    }
}
```

**TestCase**
```java
package com.example.singleton.serialization;

import com.example.singleton.enumbased.EnumSingleton;

public class EnumSingletonTest {
    public static void main(String[] args) {
        EnumSingleton singleton1 = EnumSingleton.INSTANCE;
        EnumSingleton singleton2 = EnumSingleton.INSTANCE;

        singleton1.showMessage();

        System.out.println("Are both instances same? " + (singleton1 == singleton2));
    }
}
```

**o/p**
![Image](https://github.com/user-attachments/assets/5b38215b-33d7-4ca8-93c3-e10ae2b87449)