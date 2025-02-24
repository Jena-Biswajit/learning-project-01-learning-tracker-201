package com.thread;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3,
                () -> System.out.println("All threads reached the barrier. Proceeding..."));

        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            new Thread(() -> {
                try {
                    System.out.println("Task " + taskId + " is waiting at barrier.");
                    barrier.await(); // Wait for all threads to reach here
                    System.out.println("Task " + taskId + " passed the barrier.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
