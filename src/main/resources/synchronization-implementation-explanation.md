# Synchronization Block Explanation

## 1. Code Explanation (Statement by Statement)

```java
package com.thread;

class BankAccountBlockSync {
    private int balance = 1000;

    void withdraw(String name, int amount) {
        System.out.println(name + " is trying to withdraw " + amount);
        synchronized (this) { // Synchronizing only critical section
            if (balance >= amount) {
                System.out.println(name + " is withdrawing " + amount);
                balance -= amount;
                System.out.println(name + " successfully withdrew. Remaining balance: " + balance);
            } else {
                System.out.println(name + " insufficient balance to withdraw " + amount);
            }
        }
    }
}

public class SyncBlock {
    public static void main(String[] args) {
        BankAccountBlockSync account = new BankAccountBlockSync();

        Thread t1 = new Thread(() -> account.withdraw("Biswa", 800));
        Thread t2 = new Thread(() -> account.withdraw("Jit", 800));

        t1.start();
        t2.start();
    }
}
```

Defines a class `BankAccountBlockSync` representing a bank account with an initial balance of 1000.

```
void withdraw(String name, int amount) {
    System.out.println(name + " is trying to withdraw " + amount);
```

Defines a method `withdraw()` that attempts to withdraw a specified amount from the account.

```
synchronized (this) { // Synchronizing only critical section
```

Uses a **synchronized block** to ensure that only one thread can execute this section at a time, preventing race conditions.

```
if (balance >= amount) {
    System.out.println(name + " is withdrawing " + amount);
    balance -= amount;
    System.out.println(name + " successfully withdrew. Remaining balance: " + balance);
} else {
    System.out.println(name + " insufficient balance to withdraw " + amount);
}
```

- Checks if the balance is sufficient before withdrawing.
- If sufficient, the amount is deducted, and the new balance is printed.
- If insufficient, it prints an error message.

```java
public class SyncBlock {
    public static void main(String[] args) {
```

Defines the `SyncBlock` class with the `main` method, which is the entry point of the program.

```
BankAccountBlockSync account = new BankAccountBlockSync();
```

Creates a shared `BankAccountBlockSync` instance.

```
Thread t1 = new Thread(() -> account.withdraw("Biswa", 800));
Thread t2 = new Thread(() -> account.withdraw("Jit", 800));
```

Creates two threads, `t1` and `t2`, that attempt to withdraw money concurrently.

```
t1.start();
t2.start();
```

Starts both threads, which execute the `withdraw()` method simultaneously.

### 2. Understanding Synchronization Block

- Instead of synchronizing the entire method, only the critical section (balance check and withdrawal) is synchronized.
- This improves efficiency as other non-critical operations can run concurrently.

### 3. Thread Execution Scenario

1. `Biswa` tries to withdraw 800.
2. `Jit` tries to withdraw 800 at the same time.
3. Only one thread enters the synchronized block at a time.
4. If `Biswa` withdraws first, the remaining balance is 200, causing `Jit`'s withdrawal to fail.
5. If `Jit` gets access first, `Biswa`'s withdrawal fails due to insufficient balance.

### 4. Benefits of Synchronization Block

- Prevents race conditions when multiple threads access shared resources.
- Ensures only one thread modifies the critical section at a time.
- More efficient than synchronizing the entire method.

---

