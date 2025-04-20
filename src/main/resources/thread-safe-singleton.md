### Thread-Safe Singleton with Multithreading Demo

 **1) Object Creation: How and Why**

- **Declaration**: The singleton instance is declared as a `private static` variable, initially `null`:
  ```
  private static SingletonThreadSafe instance = null;
  ```
- **Creation**: The object is created **only** when **first** requested via `getInstance()`, inside a synchronized context. This delays instantiation (lazy) but enforces thread safety.

**Why this way?**
- Ensures only **one** instance is created even if multiple threads call `getInstance()` concurrently.
- Prevents race conditions without heavy locking on every access.

---

### 2) Constructor Invocation: How and Why

- The constructor is marked `private` to prevent external instantiation:
  ```
  private SingletonThreadSafe() {
      System.out.println("Thread-Safe Singleton instance created");
  }
  ```
- It is invoked exactly once when the first thread enters the synchronized block and executes `new SingletonThreadSafe()`.

**Why `private`?**
- Encapsulation: Guarantees control over instance creation.
- Singleton enforcement: No other class can call the constructor.

---

### 3) Access Method: How and Its Type

```
public static synchronized SingletonThreadSafe getInstance() {
    if (instance == null) {
        instance = new SingletonThreadSafe();
    }
    return instance;
}
```

- **Method Type**: `public static synchronized` ensures that only one thread at a time can execute this method.
- **First Call**: The first thread finds `instance == null`, enters the synchronized method, creates the instance, and returns it.
- **Subsequent Calls**: Other threads block until the creating thread exits the method, then see `instance != null` and immediately return the existing instance.

**Why `synchronized`?**
- Enforces mutual exclusion on the `getInstance()` method.
- Prevents multiple threads from creating separate instances simultaneously.

---

### 4) Multithreading Demonstration

```java
package com.example.singleton.threadsafe;

public class DemoMultiThreadSafe {
  public static void main(String[] args) {
    Runnable task = () -> {
      SingletonThreadSafe singleton = SingletonThreadSafe.getInstance();
      System.out.println(Thread.currentThread().getName()
              + " -> Instance HashCode: " + singleton.hashCode());
    };

    // Launch multiple threads to test thread safety
    Thread[] threads = new Thread[5];
    for (int i = 0; i < threads.length; i++) {
      threads[i] = new Thread(task, "Thread-" + (i + 1));
      threads[i].start();
    }
  }
}

public class SingletonThreadSafe {
  private static SingletonThreadSafe instance = null;

  private SingletonThreadSafe() {
    System.out.println("Thread-Safe Singleton instance created");
  }

  public static synchronized SingletonThreadSafe getInstance() {
    if (instance == null) {
      instance = new SingletonThreadSafe();
    }
    return instance;
  }
}

```

**Output**

![Image](https://github.com/user-attachments/assets/8f27aa76-611a-461a-9d9e-0a43493cde8e)
