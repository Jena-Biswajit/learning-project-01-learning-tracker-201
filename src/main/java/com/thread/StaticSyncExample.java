package com.thread;

class Bank {
    private static int balance = 1000; // Shared resource

    static synchronized void withdraw(String name, int amount) { // Static method synchronized
        System.out.println(name + " trying to withdraw " + amount);
        if (balance >= amount) {
            System.out.println(name + " successfully withdrew " + amount);
            balance -= amount;
        } else {
            System.out.println(name + " failed to withdraw. Insufficient funds.");
        }
        System.out.println("Remaining balance: " + balance);
    }
}

public class StaticSyncExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> Bank.withdraw("Biswa", 800));
        Thread t2 = new Thread(() -> Bank.withdraw("Jit", 500));

        t1.start();
        t2.start();
    }
}
