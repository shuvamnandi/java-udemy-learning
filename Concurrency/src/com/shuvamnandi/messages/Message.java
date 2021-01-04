package com.shuvamnandi.messages;

public class Message {
    private String message;
    private boolean empty = true;
    // empty is true when there is no message to read
    // consumer should read each message before we write another one

    // to be called by consumer
    public synchronized String read() {
        while(empty) {
            try {
                wait();
                // Suspend its execution and release the lock it's holding, repeat as long as the empty check is True
                // i.e. wait for data to come in from MyWriter thread calling Message.write()
            } catch (InterruptedException e) {

            }
        }
        empty = true;
        notifyAll(); // Signal the other waiting thread to wake up
        return message;
    }

    // to be called by producer
    public synchronized void write(String message) {
        while(!empty) {
            try {
                wait();  // Suspend its execution and release the lock it's holding
            } catch (InterruptedException e) {

            }
        }
        empty = false;
        this.message = message;
        notifyAll(); // Signal the other waiting thread to wake up
    }

    /*
     Problem with above setup: Deadlock.
     Once one of the thread starts looping, the other one cannot change the value of empty as the thread is blocked.
     Only one thread can execute a synchronized method at a time. So, the first thread that is looping is holding the lock
     for the message object. The second one is blocked waiting for the first thread to release the lock.
     */
}
