package com.shuvamnandi.multiplethreads;

import com.shuvamnandi.ThreadColor;

// Synchronization is re-entrant, the thread can acquire a lock it already owns
// Critical section refers to the code which is referencing a shared resource, like a variable. Only 1 thread at a time should be able to execute a critical section.
// Thread-safe class or method means that the developer has synchronized all the critical sections within the code, so that it is unaffected by thread interference

public class Countdown {
    // Instance variables are stored on the heap, i.e. multiple threads would share this value
    private int i;

    // Adding synchronized keyword to a method ensures that only 1 thread executes this method at a given time
    // all others are in suspended/waiting state
    public void doCountdown() {
        // Local variables are stored on the thread stack, i.e. each thread has its own copy of these.
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

        // Pass in an object (instance variable) to synchronized to lock this block of code to avoid race condition between multiple threads
        // Passing in a local variable does not help
        // Static methods can also be synchronized
        // We must synchronize only the code that needs synchronization, to an absolute minimum
        synchronized(this) {
            // Local variables are stored on the thread stack, i.e. each thread has its own copy of these.
            for (this.i = 10; this.i > 0; this.i--) {
                System.out.println(color + Thread.currentThread().getName() + " : i= " + i);
            }
        }
        // Points of suspension for any thread:
        // 1. Before the i>0 condition check
        // 2. Before the i-- decrement
        // 3. Before the System.out.println statement
        // 4. During the System.out.println statement
    }
}
