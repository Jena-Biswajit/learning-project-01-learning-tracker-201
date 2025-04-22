### Singleton design pattern 

- The **Singleton Design Pattern** ensures that **only one instance** of a class exists throughout the entire application and provides a **global access point** to that instance.

---

### Think of it like:

-  A printer driver — you don't want multiple printers printing at once randomly.
-  A configuration manager — only one set of global app settings.
-  A database connection pool — managed by one central controller.

---

### Why Do We Need It?

- **Consistency**: All parts of the app use the same instance.
- **Controlled Access**: You can control how and when the instance is used.
- **Resource Saving**: No unnecessary objects = less memory and CPU usage.
- **Global Access**: Easy to access from anywhere without creating new objects.

---

### When and Where to Use It?

### Use Singleton when:

- You want to control **shared resources** (DB, file, printer).
- You need a **central configuration** or settings handler.
- You want to prevent multiple instances due to **business logic** (like licensing).

### Avoid Singleton when:

- You need **multiple independent instances**.
- You want your class to be **easily testable** (Singletons are harder to mock).
- You need **inheritance** (Singleton with `enum` doesn’t support it well).

---

### Singleton with Early (Eager) Loading

**1) Object Creation: How and Why**

**How is the object created?**

- In eager loading, the Singleton instance is created at the time of class loading.
- This is achieved by declaring a `private static final` instance of the class and initializing it directly:

```java
package com.example.singleton.eager;

public class SingletonEager {

    public static SingletonEager singletonEager = new SingletonEager();

    private SingletonEager(){
        System.out.println("Eager Singleton Created");
    }
    public static SingletonEager getSingletonEager(){
        return singletonEager;
    }
}
```

- When the `SingletonEager` class is loaded into memory by the Java Virtual Machine (JVM), this static field is initialized .
- The constructor is invoked to create the instance.

**Why is it created this way?**

- **Thread Safety**: Class loading in Java is thread-safe. 
- The JVM ensures that the class is loaded and initialized only once, even in multithreaded environments. 
- This guarantees that only one instance of the Singleton class is created.
- **Simplicity**: Eager initialization is straightforward to implement and doesn't require complex synchronization mechanisms.

> **Consideration**: If the Singleton instance is resource-intensive and might not be used during the application's lifecycle, eager initialization can lead to unnecessary resource consumption.

### 2) Constructor Invocation: How and Why

**How is the constructor called?**

The constructor is declared as `private` to prevent external instantiation:

```
private SingletonEager() {
    System.out.println("Eager Singleton Created");
}
```

This constructor is invoked internally when the static `instance` field is initialized:

```
private static final SingletonEager singletonEager = new SingletonEager();
```

**Why is the constructor private?**

- **Encapsulation**: Restricts instantiation of the class from outside, ensuring that only one instance exists.
- **Control**: Provides control over the instantiation process, allowing the class to manage its sole instance.

### 3) Access Method: How and Its Type

**How is the Singleton instance accessed?**

A public static method provides global access to the Singleton instance:

```
public static SingletonEager getSingletonEager() {
    return singletonEager;
}
```

**Type of Method**: This is a **static method**, meaning it belongs to the class rather than any particular object instance.

**Why use a static method?**

- **Global Access Point**: Allows other classes to access the Singleton instance without creating a new object.
- **Consistency**: Ensures that all parts of the application use the same instance.

### 4) Summary of Concepts

- **Singleton Pattern**: Ensures a class has only one instance and provides a global point of access to it.
- **Eager Initialization**: The Singleton instance is created at the time of class loading.
- **Private Constructor**: Prevents external instantiation of the class.
- **Static Instance**: Holds the sole instance of the class, initialized during class loading.
- **Public Static Accessor**: Provides global access to the Singleton instance.

### 5) Additional Insights

- **Thread Safety**: Eager initialization is inherently thread-safe due to the JVM's class loading mechanism.
- **Resource Management**: Suitable when the Singleton instance is lightweight or when it's certain that it will be used during the application's lifecycle.
- **Limitations**: Not ideal if the Singleton instance is resource-intensive and might not be used, as it leads to unnecessary resource allocation.

### Singleton Pattern with Lazy Loading

### 1) Object Creation: How and Why

**How is the object created?**

**Example**
```java
package com.example.singleton.lazy;

public class SingletonLazy {

    private static SingletonLazy singletonLazy = null;

    private SingletonLazy() {
        System.out.println("Lazy Singleton Created");
    }

    public static SingletonLazy getSingletonLazy() {

        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
}
```

- The Singleton instance is declared as a `private static` variable initialized to `null`:

    ```
    private static SingletonLazy singletonLazy = null;
    ```
- The object is created **only** when `getSingletonLazy()` is called for the first time:

    ```
    public static SingletonLazy getSingletonLazy() {

        if (singletonLazy == null) {
            singletonLazy = new SingletonLazy();
        }
        return singletonLazy;
    }
    ```

**Why this way?**

- **Resource Efficiency**: Delays instantiation until the object is actually needed, avoiding unnecessary memory usage if the Singleton is never used.
- **Control**: No instance is created during class loading, giving finer control over when the object comes into existence.

### 2) Constructor Invocation: How and Why

**How is the constructor called?**

- The constructor is declared as `private` to prevent external instantiation:

    ```
    private SingletonLazy() {
        System.out.println("Lazy Singleton Created");
    }
    ```
- It is invoked internally inside the `getInstance()` method when `new SingletonLazy()` executes on the first call.

**Why `private`?**

- **Encapsulation**: Prevents other classes from creating new instances, ensuring the Singleton property.
- **Control Flow**: Allows the class itself to manage the timing of its instantiation.

### 3) Access Method: How and Its Type

**How is `getSingletonLazy()` called?**

- It is a **public static** method:

    ```
    public static SingletonLazy getSingletonLazy() { ... }
    ```
- Called as `SingletonLazy.getInstance()`, with no existing object reference required.

**Why `static`?**

- **Global Access Point**: Belongs to the class, enabling invocation before any object instance exists.
- **Consistency**: Ensures a single, shared access point for obtaining the Singleton instance.


- **Disadvantages**: Not thread-safe by default; simultaneous calls may create multiple instances.
- **Thread Safety Note**: Introduction to using `synchronized` blocks for multithreading scenarios.

## 5) Pros and Cons

| Pros                               | Cons                                    |
|------------------------------------|-----------------------------------------|
| Resource-efficient instantiation   | Not thread-safe by default              |
| Controls timing of object creation | Requires extra handling for concurrency |

---

**o/p**

![Image](https://github.com/user-attachments/assets/4f7bcbd3-a4e3-46b6-b0d0-300a258d8328)
