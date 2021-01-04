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
        // Static methods can also be synchronized and can also use synchronize on static objects
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

        // Atomic Operations in Java, during the execution of which a thread cannot be suspended
        // 1. Reading or writing reference variables, e.g. myObject1 = myObject2
        // 2. Reading or writing primitive variables (except for type long and double, which require 2 operations), e.g. myInt = 10
        // 3. Reading or writing all variables declared volatile
        // 4. Reading or writing a thread-safe Java Collections object, e.g. Vector is thread-safe but ArrayList is not thread-safe
    }
}
