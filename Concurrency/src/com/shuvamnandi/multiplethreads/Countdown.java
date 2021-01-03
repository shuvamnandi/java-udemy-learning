package com.shuvamnandi.multiplethreads;

import com.shuvamnandi.ThreadColor;

public class Countdown {
    // Instance variables are stored on the heap, i.e. multiple threads would share this value
    private int i;

    public void doCountdown() {
        String color;

        switch (Thread.currentThread().getName()) {
            case "Thread-1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread-2":
                color = ThreadColor.ANSI_GREEN;
                break;
            default:
                color = ThreadColor.ANSI_PURPLE;
        }
        // Local variables are stored on the thread stack, i.e. each thread has its own copy of these.
        for (this.i=10; this.i>0; this.i--) {
            System.out.println(color + Thread.currentThread().getName() + " : i= " + i);
        }
        // Points of suspension for any thread:
        // 1. Before the i>0 condition check
        // 2. Before the i-- decrement
        // 3. Before the System.out.println statement
        // 4. During the System.out.println statement
    }
}
