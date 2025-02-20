package com.thread;

class BankAccountSync {
    private int balance = 1000;

    synchronized void withdraw(String name, int amount) { // Instance method synchronized
        if (balance >= amount) {
            System.out.println(name + " is withdrawing " + amount);
            balance -= amount;
            System.out.println(name + " successfully withdrew. Remaining balance: " + balance);
        } else {
            System.out.println(name + " insufficient balance to withdraw " + amount);
        }
    }
}

public class SyncInstanceMethod {
    public static void main(String[] args) {
        BankAccountSync account = new BankAccountSync();

        Thread t1 = new Thread(() -> account.withdraw("Biswa", 800));
        Thread t2 = new Thread(() -> account.withdraw("Jit", 800));

        t1.start();
        t2.start();
    }
}