package com.thread;

class ATM {
    private int balance = 1000; // Shared resource

    void withdraw(String name, int amount) {
        System.out.println(name + " trying to withdraw " + amount);
        synchronized (this) { // Only the critical section is locked
            if (balance >= amount) {
                System.out.println(name + " successfully withdrew " + amount);
                balance -= amount;
            } else {
                System.out.println(name + " failed to withdraw. Insufficient funds.");
            }
            System.out.println("Remaining balance: " + balance);
        }
    }
}

public class SyncBlockExample {
    public static void main(String[] args) {
        ATM atm = new ATM(); // Shared object

        Thread t1 = new Thread(() -> atm.withdraw("Alice", 800));
        Thread t2 = new Thread(() -> atm.withdraw("Bob", 500));

        t1.start();
        t2.start();
    }
}