package com.shuvamnandi.producerconsumer;

import java.util.List;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class MyProducer implements Runnable {
    private List<String> buffer;
    private String printColor;
    private ReentrantLock bufferLock;

    public MyProducer(List<String> buffer, String printColor, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.printColor = printColor;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        Random random = new Random();
        String[] numbers = { "1", "2", "3", "4", "5"};
        int[] nums = {1, 2, 3, 4, 5};

        for (String number: numbers) {
            try {
                System.out.println(printColor + "Adding..." + number);
                bufferLock.lock(); // Acquire the lock - it will either get the lock or it will be suspended until it can get the lock
                buffer.add(number);
                bufferLock.unlock(); // Release the lock - this must be managed by developers
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                System.out.println(printColor + "Producer was interrupted");
            }
        }
        System.out.println(printColor + "Adding EOF and exiting....");
        bufferLock.lock();
        buffer.add("EOF");
        bufferLock.unlock();
    }
}
