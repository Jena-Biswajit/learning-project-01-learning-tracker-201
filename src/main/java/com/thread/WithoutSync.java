package com.thread;

class BankAccount {
    private int balance = 1000;

    void withdraw(String name, int amount) {
        if (balance >= amount) {
            System.out.println(name + " is withdrawing " + amount);
            balance -= amount;
            System.out.println(name + " successfully withdrew. Remaining balance: " + balance);
        } else {
            System.out.println(name + " insufficient balance to withdraw " + amount);
        }
    }
}

public class WithoutSync {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.withdraw("Biswa", 800));
        Thread t2 = new Thread(() -> account.withdraw("Jit", 800));

        t1.start();
        t2.start();
    }
}
