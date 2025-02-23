package com.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorShutdownExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        for (int i = 1; i <= 3; i++) {
            final int taskId = i;
            executor.execute(() -> {
                try {
                    System.out.println("Task " + taskId + " started.");
                    Thread.sleep(2000);
                    System.out.println("Task " + taskId + " completed.");
                } catch (InterruptedException e) {
                    System.out.println("Task " + taskId + " interrupted.");
                }
            });
        }

        //executor.shutdown(); // Graceful shutdown
        executor.shutdownNow(); // Force shutdown

        if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
            System.out.println("Forcing shutdown...");
            executor.shutdownNow();
        }
    }
}
