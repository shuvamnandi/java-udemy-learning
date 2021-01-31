package com.shuvam.learning;

public class Main {

    static {
        System.out.println("before...");
    }

    public static void main(String[] args) {
        Thread myThread = new Thread(new InterruptExample(), "myThread");
        // myThread.setDaemon(true);
        myThread.start();
        System.out.println("["+Thread.currentThread().getName()+"] Sleeping in main thread for 5s...");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            System.out.println("["+Thread.currentThread().getName()+" was interrupted");
        }
        System.out.println("["+Thread.currentThread().getName()+"] Interrupting myThread");
        // myThread.interrupt();
        TwoSum twoSum = new TwoSum();
        int[] indices = twoSum.twoSum(new int[]{2,7,11,15}, 9);
        for(int i: indices) {
            System.out.println(i);
        }

        String i;
        System.out.println(200+300+"Int I: ");
        System.out.println(""+200+300+"Int I: ");

        BiCounter biCounter = new BiCounter();
        Thread t1 = new Thread(()->{
            biCounter.incrementJ();
            biCounter.incrementI();
        });

        Thread t2 = new Thread(()->{
            biCounter.incrementI();
            biCounter.incrementJ();
        });

        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        } catch (InterruptedException e) {

        }

        System.out.println(biCounter.getI() +" " + biCounter.getJ());
    }
}
