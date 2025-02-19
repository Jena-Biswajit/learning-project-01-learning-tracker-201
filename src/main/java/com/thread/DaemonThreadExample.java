package com.thread;

class DaemonThread extends Thread {
    public void run() {
        if (isDaemon()) {
            System.out.println(Thread.currentThread().getName() + " is a daemon thread.");
        } else {
            System.out.println(Thread.currentThread().getName() + " is a user thread.");
        }
    }
}

public class DaemonThreadExample {
    public static void main(String[] args) {
        DaemonThread t1 = new DaemonThread();
        DaemonThread t2 = new DaemonThread();

        t1.setDaemon(true); // Must be set before starting the thread

        t1.start();
        t2.start();
    }
}
