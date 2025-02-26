### wait-and-notify 

### Overview
The **Producer-Consumer problem** is a classic synchronization problem in multithreading, where one thread (Producer) generates data and another thread (Consumer) processes it. To ensure proper execution, they share a common resource and use synchronization mechanisms to avoid race conditions.

### Code Explanation
### 1. **SharedResource Class** (Shared Buffer)
```java
class SharedResource {
    private int data;
    private boolean available = false;

    public synchronized void produce(int value) throws InterruptedException {
        while (available) {
            wait();
        }
        data = value;
        available = true;
        System.out.println("Produced: " + data);
        notify();
    }

    public synchronized void consume() throws InterruptedException {
        while (!available) {
            wait();
        }
        System.out.println("Consumed: " + data);
        available = false;
        notify();
    }
}
```
### Internal Working
- **`data`**: Stores the shared data.
- **`available`**: Flag indicating whether new data is available.
- **`synchronized` methods**: Ensure mutual exclusion when accessing shared data.
- **`wait()`**: If data is available (in `produce()`) or unavailable (in `consume()`), the thread waits.
- **`notify()`**: Wakes up the waiting thread when data is produced or consumed.

### 2. **Producer Class**
```java
class Producer extends Thread {
    private SharedResource resource;

    public Producer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                resource.produce(i);
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```
- Calls `produce(i)`, adding numbers (1 to 5) to the shared resource.
- `Thread.sleep(500)`: Simulates time delay between productions.

### 3. **Consumer Class**
```java
class Consumer extends Thread {
    private SharedResource resource;

    public Consumer(SharedResource resource) {
        this.resource = resource;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                resource.consume();
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
```
- Calls `consume()`, consuming numbers (1 to 5) from the shared resource.
- `Thread.sleep(500)`: Simulates time delay between consumptions.

### 4. **Main Class (Thread Execution)**
```java
public class ProducerConsumer {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();
        new Producer(resource).start();
        new Consumer(resource).start();
    }
}
```
- Creates a shared resource.
- Starts Producer and Consumer threads.

### **Understanding `wait()` and `notify()`**
### `wait()`
- A thread calling `wait()` enters the **waiting state**.
- It releases the lock on the synchronized object and waits for a `notify()` signal.
- Used when the Producer has already produced data (in `produce()`) or when the Consumer has no data to consume (in `consume()`).

### `notify()`
- Wakes up a single waiting thread.
- Used when the Producer generates new data or when the Consumer finishes processing data.
- Ensures that both threads take turns accessing the shared resource.

### Execution Flow
1. **Producer Thread** starts and calls `produce(1)`.
2. **Consumer Thread** starts but waits (`wait()`) since no data is available.
3. Producer produces `1`, calls `notify()`, and Consumer wakes up to consume `1`.
4. Consumer calls `notify()`, waking up the Producer for the next iteration.
5. This cycle continues until all numbers are produced and consumed.

### Conclusion
This example demonstrates how **inter-thread communication** works using `wait()` and `notify()`. It ensures synchronization between Producer and Consumer threads, preventing **race conditions** and ensuring smooth execution of tasks.

---


