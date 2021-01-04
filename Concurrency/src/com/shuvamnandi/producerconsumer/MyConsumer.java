package com.shuvamnandi.producerconsumer;

import java.util.List;

public class MyConsumer implements Runnable {
    private List<String> buffer;
    private String printColor;

    public MyConsumer(List<String> buffer, String printColor) {
        this.buffer = buffer;
        this.printColor = printColor;
    }

    @Override
    public void run() {
        /*
        When a class is synchronized or thread safe, we can be confident that each time a thread calls a method
        in the class, no other threads will be able to run a method in the class until the first thread is finished
        executing the method
        So, in other words if thread A is running synchronized method x in class Y, then thread B can't run any methods
        in class Y until thread A has finished running method X. That's even if thread A is suspended.

        Now, it doesn't mean that if thread A would have called 3 methods in a row in class Y, it can run all 3 methods
        without worrying about interference from another thread B. If thread A is suspended after it's finished
        running a method in class Y, another thread B can run a method in class Y before thread A has the chance to
        run again. So, in other words, the following can happen when using a class Y that is synchronized or thread-safe
        1. Thread A runs a method in class Y
        2. Thread B runs a method in class Y
        3. Thread A runs a method in class Y
        and again that can happen in the case of them being synchronized and thread safe.
        This is what happens in the below case, 2 consumer threads try to remove the same data from the buffer,
        causing thread interference and leading to an IndexOutOfBoundsException.
         */
        while(true) {
            if (buffer.isEmpty()) {
                continue; // skip this iteration of the while loop
            }
            if (buffer.get(0).equals("EOF")) {
                System.out.println(printColor + "Exiting...");
                break;
            } else {
                System.out.println(printColor + "Removed " + buffer.remove(0));
            }
        }
    }
}
