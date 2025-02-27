package com.thread;

class SharedResource1 {
    synchronized void printNumbers(int n) {  // Implicit lock on 'this'
        for (int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + (n * i));
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class InstanceLockExample {
    public static void main(String[] args) {
        SharedResource1 obj = new SharedResource1(); // Single shared object

        Thread t1 = new Thread(() -> obj.printNumbers(5), "Thread 1");
        Thread t2 = new Thread(() -> obj.printNumbers(10), "Thread 2");

        t1.start();
        t2.start();
    }
}

