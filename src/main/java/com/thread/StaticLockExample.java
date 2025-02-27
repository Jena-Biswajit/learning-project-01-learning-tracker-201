package com.thread;

class SharedStatic {
    synchronized static void printNumbers(int n) {  // Lock on SharedStatic.class
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

public class StaticLockExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> SharedStatic.printNumbers(5), "Thread 1");
        Thread t2 = new Thread(() -> SharedStatic.printNumbers(10), "Thread 2");

        t1.start();
        t2.start();
    }
}
