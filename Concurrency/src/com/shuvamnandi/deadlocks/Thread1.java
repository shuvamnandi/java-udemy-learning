package com.shuvamnandi.deadlocks;

public class Thread1 extends Thread {
    private Object lock1;
    private Object lock2;

    public Thread1(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        synchronized (lock1) {
            System.out.println("Thread 1: Has lock1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e){

            }
            System.out.println("Thread 1: Waiting for lock2");
            synchronized (lock2) {
                System.out.println("Thread 1: Has lock1 and lock2");
            }
            System.out.println("Thread 1: Released lock2");
        }
        System.out.println("Thread 1: Released lock1. Exiting...");
    }
}
