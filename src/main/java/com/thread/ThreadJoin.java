package com.thread;


class JoinExample extends Thread {
    public void run() {
        System.out.println(Thread.currentThread().getName() + " is running.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        System.out.println(Thread.currentThread().getName() + " finished execution.");
    }
}

public class ThreadJoin {
    public static void main(String[] args) {
        JoinExample t1 = new JoinExample();
        JoinExample t2 = new JoinExample();

        t1.start();
        try {
            t1.join(); // Main thread waits until t1 completes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t2.start();
    }
}
