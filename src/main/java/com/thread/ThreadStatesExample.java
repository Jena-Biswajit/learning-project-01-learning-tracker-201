package com.thread;

class ThreadStates extends Thread {
    public void run() {
        System.out.println("Thread State: " + getState()); // RUNNABLE
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread State after sleep: " + getState()); // TIMED_WAITING
    }
}

public class ThreadStatesExample {
    public static void main(String[] args) {
        ThreadStates t = new ThreadStates();
        System.out.println("State before start: " + t.getState()); // NEW

        t.start();
        System.out.println("State after start: " + t.getState()); // RUNNABLE

        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("State after completion: " + t.getState()); // TERMINATED
    }
}
