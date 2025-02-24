package com.thread;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(3); // 3 tasks need to finish

        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            new Thread(() -> {
                try {
                    System.out.println("Task " + taskId + " started.");
                    Thread.sleep(1000 * taskId); // Simulating work
                    System.out.println("Task " + taskId + " completed.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown(); // Reduce the count
                }
            }).start();
        }

        try {
            System.out.println("Main thread waiting...");
            latch.await(); // Wait until count reaches 0
            System.out.println("All tasks completed. Main thread resumes.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
