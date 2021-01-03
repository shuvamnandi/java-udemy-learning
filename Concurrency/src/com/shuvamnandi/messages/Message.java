package com.shuvamnandi.messages;

public class Message {
    private String message;
    private boolean empty = true;
    // empty is true when there is no message to read
    // consumer should read each message before we write another one

    // to be called by consumer
    public synchronized String read() {
        while(empty) {

        }
        empty = true;
        return message;
    }

    // to be called by producer
    public synchronized void write(String message) {
        while(!empty) {

        }
        empty = false;
        this.message = message;
    }

    /*
     Problem with above setup: Deadlock.
     Once one of the thread starts looping, the other one cannot change the value of empty as the thread is blocked.
     Only one thread can execute a synchronized method at a time. So, the first thread that is looping is holding the lock
     for the message object. The second one is blocked waiting for the first thread to release the lock.
     */
}
