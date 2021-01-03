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
}
