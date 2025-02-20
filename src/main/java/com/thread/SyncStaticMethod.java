package com.thread;

class BankStatic {
    private static int balance = 1000;

    static synchronized void withdraw(String name, int amount) {  // Static method synchronized
        if (balance >= amount) {
            System.out.println(name + " is withdrawing " + amount);
            balance -= amount;
            System.out.println(name + " successfully withdrew. Remaining balance: " + balance);
        } else {
            System.out.println(name + " insufficient balance to withdraw " + amount);
        }
    }
}

public class SyncStaticMethod {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> BankStatic.withdraw("Biswa", 800));
        Thread t2 = new Thread(() -> BankStatic.withdraw("Jit", 800));

        t1.start();
        t2.start();
    }
}