package com.shuvamnandi.producerconsumer;

import java.util.List;
import java.util.Random;

public class MyProducer implements Runnable {
    private List<String> buffer;
    private String printColor;

    public MyProducer(List<String> buffer, String printColor) {
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
                buffer.add(number);
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e){
                System.out.println(printColor + "Producer was interrupted");
            }
        }
        System.out.println(printColor + "Adding EOF and exiting....");
        buffer.add("EOF");
    }
}
