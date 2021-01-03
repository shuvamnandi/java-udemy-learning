package com.shuvamnandi.threads;

import static com.shuvamnandi.threads.ThreadColor.*;

public class Main {
    public static void main(String[] args) {
        System.out.println(ANSI_GREEN + "Hello from the main thread.");

        // Priority of threads is up to system scheduling
        AnotherThread anotherThread = new AnotherThread();
        anotherThread.setName("==Another Thread==");
        // anotherThread.run(); // This runs on the thread from where the run() method is called
        anotherThread.start();

        // Anonymous thread example
        new Thread() {
            public void run() {
                System.out.println(ANSI_RED + "Hello from the anonymous class thread!");
            }
        }.start();

        Thread myRunnableThread = new Thread(new MyRunnable());
        myRunnableThread.start();
        // anotherThread.interrupt();

        new Thread(new MyRunnable(){
            @Override
            public void run() {
                System.out.println(ANSI_CYAN + "Hello from the anonymous class's implementation of run!");
                try{
                    System.out.println(ANSI_CYAN + "Waiting until anotherThread is complete.");
                    anotherThread.join(20000);
                    System.out.println(ANSI_CYAN + "I am running again after anotherThread is complete or time out.");
                } catch (InterruptedException e) {
                    System.out.println(ANSI_CYAN + "I couldn't wait after all. I was interrupted");
                    return;
                }
            }
        }).start();

        System.out.println(ANSI_GREEN + "Hello again from the main thread.");
        // anotherThread.start(); // gives an IllegalThreadStateException on calling start() once again
    }
}
