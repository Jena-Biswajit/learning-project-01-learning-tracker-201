package com.thread;

class StopThread extends Thread {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println(Thread.currentThread().getName() + " is running...");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + " has stopped.");
    }

    public void stopThread() {
        running = false;
    }
}

public class StopThreadExample {
    public static void main(String[] args) {
        StopThread t1 = new StopThread();
        t1.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t1.stopThread(); // Graceful stop
    }
}

