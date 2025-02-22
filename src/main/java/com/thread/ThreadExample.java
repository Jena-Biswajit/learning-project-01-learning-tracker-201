package com.thread;

public class ThreadExample {
    public static void main(String[] args) {
        Thread t = new Thread(() -> {
            System.out.println("Thread Name: " + Thread.currentThread().getName());
            System.out.println("Thread ID: " + Thread.currentThread().getId());
        });

        t.start();
    }
}
