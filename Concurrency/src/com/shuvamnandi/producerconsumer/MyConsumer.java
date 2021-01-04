package com.shuvamnandi.producerconsumer;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MyConsumer implements Runnable {
    private List<String> buffer;
    private String printColor;
    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String printColor, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.printColor = printColor;
        this.bufferLock = bufferLock;
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

        However, synchronization does have some drawbacks.
        1. Threads that are blocked waiting to execute synchronize code can't be interrupted. Once they're blocked
        they are stuck there until they get the lock for the object the code is synchronizing on.
        2. The synchronized block must be within the same method. In other words, we can't start a synchronized block
        in one method and end the synchronization block in another for obvious reasons.
        3. We can't test to see if an object's intrinsic lock is available or find out any other information about
        that lock. Also, if the lock isn't available we can't timeout after we waited for the lock for a while.
        When we reach the beginning of a synchronized block, we can either get the lock and continue executing,
        or block at that line of code until we get the lock.
        4. If multiple threads are waiting to get a lock, it's not on first come first served basis. There isn't a set
        order in which the JVM will choose the next thread that gets the lock, so the first thread that blocked could be
        the last thread to get the lock and vice versa.
        Therefore, instead of using synchronization we can prevent thread interference using classes that implement the
        java.util.concurrent locks.lock interface
         */
        while(true) {
            // The whole code is a critical section as we want this whole block of code as a single unit
            bufferLock.lock();
            if (buffer.isEmpty()) {
                continue; // skip this iteration of the while loop
            }
            if (buffer.get(0).equals("EOF")) {
                System.out.println(printColor + "Exiting...");
                break;
            } else {
                System.out.println(printColor + "Removed " + buffer.remove(0));
            }
            bufferLock.unlock(); // The bufferLock.unlock() code is never called as buffer.isEmpty() is True
            // and it keeps getting skipped by calling continue in line 56, which causes the thread to continue to
            // acquire the lock. We never released the lock eventually leading to Maximum lock count exceeded exception thrown.
        }
    }
}
