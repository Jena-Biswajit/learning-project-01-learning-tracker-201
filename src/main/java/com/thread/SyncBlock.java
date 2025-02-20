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

        Thread t1 = new Thread(() -> account.withdraw("Alice", 800));
        Thread t2 = new Thread(() -> account.withdraw("Bob", 800));

        t1.start();
        t2.start();
    }
}
