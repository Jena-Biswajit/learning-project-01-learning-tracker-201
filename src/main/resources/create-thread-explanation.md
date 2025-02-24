
###  Create Thread Code Explanation


```java
package com.thread;

class RunnableThread implements Runnable {
    public void run() {
        System.out.println("Runnable Thread: " + Thread.currentThread().getName() + " State: "
                + Thread.currentThread().getState());
    }
}

class ThreadClass extends Thread {
    public void run() {
        System.out.println(
                "ThreadClass: " + Thread.currentThread().getName() + " State: " + Thread.currentThread().getState());
    }
}

// create thread using runnable interfce
public class CreateThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableThread(), "RunnableThread");
        Thread t2 = new ThreadClass();
        t2.setName("ThreadClass");

        // start the thread
        t1.start();
        t2.start();

    }
}
```

Defines a class `RunnableThread` that implements the `Runnable` interface.

- Implements the `run()` method, which prints the current thread’s name and state.
- `Thread.currentThread()` retrieves the currently executing thread.
- `getName()` returns the thread's name.
- `getState()` returns the current state of the thread (NEW, RUNNABLE, BLOCKED, WAITING, TIMED\_WAITING, or TERMINATED).

```java
class ThreadClass extends Thread {
    public void run() {
        System.out.println(
                "ThreadClass: " + Thread.currentThread().getName() + " State: " + Thread.currentThread().getState());
    }
}
```

Defines a class `ThreadClass` that extends `Thread`.

- Overrides the `run()` method to print the thread's name and state.

```java
public class CreateThread {
    public static void main(String[] args) {
```

Defines the `CreateThread` class with the `main` method, which is the entry point of the program.

```
Thread t1 = new Thread(new RunnableThread(), "RunnableThread");
```

Creates a new thread (`t1`) by passing an instance of `RunnableThread` to the `Thread` constructor.

- Assigns the name `RunnableThread` to `t1`.

```
Thread t2 = new ThreadClass();
t2.setName("ThreadClass");
```

Creates an instance of `ThreadClass` named `t2` and sets its name to `ThreadClass`.

```
// start the thread
t1.start();
t2.start();
```

Calls `start()` on `t1` and `t2` to begin execution of their `run()` methods in separate threads.

### 2. Differences Between `Runnable` and `Thread`

| Feature          | `Runnable` Interface                 | `Thread` Class                                                                 |
| ---------------- | ------------------------------------ | ------------------------------------------------------------------------------ |
| Extensibility    | Can extend other classes             | Cannot extend other classes (since Java does not support multiple inheritance) |
| Code Reusability | Promotes better reusability          | Less reusable due to inheritance limitations                                   |
| Resource Usage   | Uses less memory                     | Uses more memory (as each thread creates an object)                            |
| Thread Creation  | Requires an explicit `Thread` object | Directly creates a thread                                                      |

### 3. Internal Working of Threads in Java

### 3.1 `start()` Method Internal Flow

When `start()` is called on a thread, the JVM performs the following:

1. Calls the native method `start0()` (written in C++) which interacts with the OS.
2. The OS allocates resources (stack memory, CPU time, etc.) for the new thread.
3. The `run()` method is invoked in a separate call stack.

### 3.2 `run()` Method Execution

- If `run()` is called directly instead of `start()`, it executes in the **main thread** rather than a new thread.
- The `start()` method internally calls `run()` but in a separate thread.

### 3.3 Thread Lifecycle

1. **NEW**: Thread is created but `start()` is not called yet.
2. **RUNNABLE**: After calling `start()`, the thread is ready to run but waiting for CPU time.
3. **BLOCKED/WAITING**: The thread is waiting for a resource (e.g., I/O or synchronization lock).
4. **TERMINATED**: The thread has finished execution.

### 3.4 Scheduling in JVM

- Java uses a preemptive, priority-based scheduling mechanism handled by the OS.
- The `ThreadScheduler` in JVM determines which thread runs next based on priority and state.

### 3.5 Native Implementation

- Java threads are mapped to OS-level threads using `pthread` in Linux/macOS and `CreateThread()` in Windows.
- `Thread.sleep()` and `wait()` cause the thread to pause, allowing CPU time to other threads.

---


###  Java Thread Stopping Example

### 1. Code Explanation (Statement by Statement)

```java
package com.thread;

class StopThread extends Thread {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println(Thread.currentThread().getName() + " is running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " has stopped.");
    }

    public void stopThread() {
        running = false;
    }
}

public class StopThreadExample {
    public static void main(String[] args) {
        StopThread t1 = new StopThread();
        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.stopThread(); // Graceful stop
    }
}
```
Defines a class `StopThread` that extends `Thread`.
- Declares a `volatile boolean running`, ensuring visibility across threads to stop execution safely.

```
public void run() {
    while (running) {
        System.out.println(Thread.currentThread().getName() + " is running...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    System.out.println(Thread.currentThread().getName() + " has stopped.");
}
```
- The `run()` method continuously prints the thread name while `running` is `true`.
- `Thread.sleep(500);` makes the thread sleep for 500ms between executions.
- When `running` is set to `false`, the loop exits, printing a termination message.

```
public void stopThread() {
    running = false;
}
```
- Provides a method `stopThread()` to set `running` to `false`, signaling the thread to stop execution.

```java
public class StopThreadExample {
    public static void main(String[] args) {
```
Defines the `StopThreadExample` class with the `main` method, which serves as the program's entry point.

```
StopThread t1 = new StopThread();
t1.start();
```
- Creates an instance of `StopThread`.
- Calls `start()`, which triggers execution of the `run()` method in a new thread.

```
try {
    Thread.sleep(2000);
} catch (InterruptedException e) {
    e.printStackTrace();
}
```
- The main thread sleeps for 2 seconds, allowing `t1` to run.

```
t1.stopThread(); // Graceful stop
```
- Calls `stopThread()`, setting `running = false`, allowing `t1` to stop gracefully.

### 2. Why Use `volatile`?

- The `volatile` keyword ensures changes to `running` are immediately visible across threads.
- Without `volatile`, one thread may not see changes made by another thread due to caching optimizations.

### 3. Alternative Ways to Stop a Thread

| Method                             | Description                                                     |
|------------------------------------|-----------------------------------------------------------------|
| Using a `volatile` flag            | Ensures safe stopping without forceful termination.             |
| Using `Thread.interrupt()`         | Requests a thread to stop, useful for waiting/sleeping threads. |
| Using `ExecutorService.shutdown()` | Gracefully stops thread pools.                                  |
| Using deprecated `stop()`          | Unsafe, forcefully terminates a thread (not recommended).       |

### 4. Internal Working of `volatile`

### 4.1 Memory Visibility
- `volatile` ensures that updates to the `running` variable are directly written to main memory.
- Other threads always read the latest value from memory instead of cached values.

### 4.2 Thread Synchronization
- Normally, Java threads use **CPU caches** for efficiency.
- `volatile` prevents caching, ensuring all threads access the most recent value of `running`.

---

### Threads Join  Explanation

### 1. Code Explanation (Statement by Statement)

```
package com.thread;


class JoinExample extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(Thread.currentThread().getName() + " finished execution.");
    }
}

public class ThreadJoin {
    public static void main(String[] args) {
        JoinExample t1 = new JoinExample();
        JoinExample t2 = new JoinExample();

        t1.start();
        try {
            t1.join(); // Main thread waits until t1 completes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }
}
```
Defines a class `JoinExample` that extends `Thread`.

- The `run()` method prints the current thread’s name, then sleeps for 1 second.
- `Thread.sleep(1000)` pauses execution for 1000 milliseconds.
- After sleeping, it prints that the thread has finished execution.

```
public class ThreadJoin {
    public static void main(String[] args) {
```
Defines the `ThreadJoin` class with the `main` method, which is the entry point of the program.

```
JoinExample t1 = new JoinExample();
JoinExample t2 = new JoinExample();
```
Creates two threads, `t1` and `t2`, from the `JoinExample` class.

```
t1.start();
```
Starts the execution of thread `t1`.

```
try {
    t1.join(); // Main thread waits until t1 completes
} catch (InterruptedException e) {
    e.printStackTrace();
}
```
- `t1.join()` makes the main thread wait for `t1` to finish execution before continuing.
- If `t1` is interrupted while waiting, an `InterruptedException` is caught and printed.

```
t2.start();
```
Starts the execution of `t2` only after `t1` has completed execution.

### 2. How `join()` Works in Java

- When a thread calls `join()` on another thread, the calling thread is blocked until the specified thread completes execution.
- In this example, `t1.join()` ensures `t1` completes before `t2` starts.

### 3. Thread Lifecycle with `join()`

1. **NEW**: `t1` and `t2` are created but not started yet.
2. **RUNNABLE**: `t1.start()` makes `t1` eligible for execution.
3. **TIMED_WAITING**: `Thread.sleep(1000)` causes `t1` to pause for 1 second.
4. **TERMINATED**: `t1` completes execution, allowing `t2` to start.

### 4. Internal Working of `join()`

- `join()` internally uses `wait()` to pause the calling thread.
- The JVM uses OS-level thread scheduling to determine when `t1` finishes before allowing `t2` to execute.
- If `join()` is not used, both threads `t1` and `t2` may run concurrently without any order guarantee.

---

### PriorityThread Explanation

```java
package com.thread;

class PriorityThread extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " Priority: " + Thread.currentThread().getPriority());
    }
}

public class ThreadPriority {
    public static void main(String[] args) {
        PriorityThread t1 = new PriorityThread();
        PriorityThread t2 = new PriorityThread();

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        t1.start();
        t2.start();
    }
}

}
```

Defines a class `PriorityThread` that extends `Thread`.

- Overrides the `run()` method to print the current thread’s name and priority.
- `Thread.currentThread()` retrieves the currently executing thread.
- `getPriority()` returns the priority of the current thread.

```java
public class ThreadPriority {
    public static void main(String[] args) {
```

Defines the `ThreadPriority` class with the `main` method, which is the entry point of the program.

```
PriorityThread t1 = new PriorityThread();
PriorityThread t2 = new PriorityThread();
```

Creates two instances of `PriorityThread` named `t1` and `t2`.

```
t1.setPriority(Thread.MIN_PRIORITY);
t2.setPriority(Thread.MAX_PRIORITY);
```

- Sets the priority of `t1` to the minimum (`1`).
- Sets the priority of `t2` to the maximum (`10`).

```
t1.start();
t2.start();
```

Starts both threads, allowing them to run concurrently.

### 2. Understanding Thread Priorities

- Java thread priorities range from **1 (MIN_PRIORITY)** to **10 (MAX_PRIORITY)**.
- The **default priority** of a thread is **5 (NORM_PRIORITY)**.
- Higher priority does **not** guarantee execution order but increases the chance of being scheduled earlier.

### 3. Internal Working of Thread Priorities

### 3.1 Scheduling in JVM

- Java uses a **preemptive, priority-based scheduling mechanism** managed by the OS.
- The scheduler chooses which thread runs based on its priority and availability of CPU resources.

### 3.2 Native Implementation

- Java threads are mapped to OS-level threads (`pthread` in Linux/macOS, `CreateThread()` in Windows).
- The OS ultimately decides which thread runs, making priority hints rather than strict execution rules.

### 3.3 Behavior in Multithreading

- Setting priority does not guarantee execution order.
- Threads with the same priority may execute in a **round-robin fashion**.
- External factors like CPU load and system resource allocation influence scheduling.

---





