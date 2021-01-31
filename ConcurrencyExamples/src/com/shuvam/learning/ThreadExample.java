package com.shuvam.learning;

import java.util.Random;

public class ThreadExample {
    private static class MyThread extends Thread {
        public MyThread(String name) {
            super(name);
        }
        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() +" started...");
                Random r = new Random();
                Thread.sleep(r.nextInt(5000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }
    }
    public static void main(String[] args) {
        MyThread myThread1 = new MyThread("myThread1");
        MyThread myThread2 = new MyThread("myThread2");
        // myThread.run(); // prints main
        myThread1.start(); // prints myThread
        myThread2.start(); // prints myThread
        try {
            myThread1.join();
            System.out.println("Done with myThread1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            myThread2.join();
            System.out.println("Done with myThread2");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Done with myThread1 and myThread2");
    }
}