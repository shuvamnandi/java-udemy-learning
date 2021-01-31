package com.shuvam.learning;

public class InterruptExample implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println("["+Thread.currentThread().getName()+"] I am going to sleep...");
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("["+Thread.currentThread().getName()+"] Interrupted by exception!");
        }
    }
}
