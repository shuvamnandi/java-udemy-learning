package com.shuvamnandi.messages;

import java.util.Random;

public class MyReader implements Runnable {
    private Message message;

    public MyReader(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        Random random = new Random();
        for(String latestMessage = message.read(); !latestMessage.equals("Finished");  ) {
            latestMessage = message.read();
            System.out.println("Message received: " +  latestMessage);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {

            }
        }
    }
}
