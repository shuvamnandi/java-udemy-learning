package com.shuvamnandi.arrayblockingqueue;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.locks.ReentrantLock;

public class MyConsumerWithArrayBlockingQueue implements Runnable {
    private ArrayBlockingQueue<String> buffer;
    private String printColor;

    public MyConsumerWithArrayBlockingQueue(ArrayBlockingQueue<String> buffer, String printColor) {
        this.buffer = buffer;
        this.printColor = printColor;
    }

    @Override
    public void run() {
        int counter = 0; // Store the no. of times the counter was not acquired
        while(true) {
            synchronized (buffer) {
                try {
                    if (buffer.isEmpty()) {
                        continue; // skip this iteration of the while loop
                    }
                    System.out.println(printColor + "Counter: " + counter);
                    counter = 0;
                    // NullPointerException may be thrown here if a thread A is suspended after getting buffer.isEmpty()
                    // as False while another thread B goes and removes the only element in the queue.
                    // When thread A wakes up and tries to peek at the top element, it gets a NullPointerException
                    // as the queue is now empty. This means that this code needs some synchronization.
                    if (buffer.peek().equals("EOF")) { // peek method does not remove the element from the queue
                        System.out.println(printColor + "Exiting...");
                        break;
                    } else {
                        System.out.println(printColor + "Removed " + buffer.take());
                    }
                } catch (InterruptedException e) {
                    System.out.println(printColor + "Taking from buffer was interrupted");
                }
            }
        }
    }
}
