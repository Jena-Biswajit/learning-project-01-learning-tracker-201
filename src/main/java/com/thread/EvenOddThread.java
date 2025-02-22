package com.thread;

class PrintEvenOdd {
    private int max;
    private int num = 1;
    private boolean isEvenTurn = false;

    public PrintEvenOdd(int max) {
        this.max = max;
    }

    public synchronized void printEven() throws InterruptedException {
        while (num <= max) {
            while (!isEvenTurn) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " - " + num);
            num++;
            isEvenTurn = false;
            notify();
        }
    }

    public synchronized void printOdd() throws InterruptedException {
        while (num <= max) {
            while (isEvenTurn) {
                wait();
            }
            System.out.println(Thread.currentThread().getName() + " - " + num);
            num++;
            isEvenTurn = true;
            notify();
        }
    }
}

public class EvenOddThread {
    public static void main(String[] args) {
        PrintEvenOdd printer = new PrintEvenOdd(10);

        Thread evenThread = new Thread(() -> {
            try {
                printer.printEven();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "EvenThread");

        Thread oddThread = new Thread(() -> {
            try {
                printer.printOdd();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "OddThread");

        oddThread.start();
        evenThread.start();
    }
}
