package com.example.singleton.threadsafe;

public class DemoMultiThreadSafe {
    public static void main(String[] args) {
        Runnable task = () -> {
            SingletonThreadSafe singleton = SingletonThreadSafe.getInstance();
            System.out.println(Thread.currentThread().getName()
                    + " -> Instance HashCode: " + singleton.hashCode());
        };

        // Launch multiple threads to test thread safety
        Thread[] threads = new Thread[5];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task, "Thread-" + (i + 1));
            threads[i].start();
        }
    }
}
