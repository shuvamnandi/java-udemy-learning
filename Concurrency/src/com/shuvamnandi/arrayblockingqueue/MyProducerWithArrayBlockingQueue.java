package com.shuvamnandi.arrayblockingqueue;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;

public class MyProducerWithArrayBlockingQueue implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String printColor;

    public MyProducerWithArrayBlockingQueue(ArrayBlockingQueue<String> buffer, String printColor) {
        this.buffer = buffer;
        this.printColor = printColor;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] numbers = { "1", "2", "3", "4", "5"};
        int[] nums = {1, 2, 3, 4, 5};

        for (String number: numbers) {
            try {
                System.out.println(printColor + "Adding..." + number);
                try {
                    buffer.put(number);
                } catch (InterruptedException e) {
                    System.out.println(printColor + "Putting " + number + " to buffer was interrupted");
                }
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println(printColor + "Producer was interrupted");
            }
        }
        System.out.println(printColor + "Adding EOF and exiting....");
        try {
            buffer.put("EOF");
        } catch (InterruptedException e) {
            System.out.println(printColor + "Putting EOF to buffer was interrupted");
        }
    }
}
