package com.thread;

import java.util.concurrent.*;

public class CallableExecutorExample {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            TimeUnit.SECONDS.sleep(2);
            return 42;
        };

        Future<Integer> future = executor.submit(task);

        try {
            System.out.println("Result: " + future.get()); // Blocks until result is available
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}
