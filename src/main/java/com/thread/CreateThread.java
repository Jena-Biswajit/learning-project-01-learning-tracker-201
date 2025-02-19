package com.thread;


class RunnableThread implements Runnable{
    public void run(){
        System.out.println("Runnable Thread: " + Thread.currentThread().getName() + " State: " + Thread.currentThread().getState());
    }
}

class ThreadClass extends Thread {
    public void run() {
        System.out.println("ThreadClass: " + Thread.currentThread().getName() + " State: " + Thread.currentThread().getState());
    }
}


// create thread using runnable interfce 
public class CreateThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(new RunnableThread(), "RunnableThread");
        Thread t2 = new ThreadClass();
        t2.setName("ThreadClass");

        t1.start();
        t2.start();
        
    }
}



