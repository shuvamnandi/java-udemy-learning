package com.shuvamnandi;

import com.shuvamnandi.messages.MyReader;
import com.shuvamnandi.messages.Message;
import com.shuvamnandi.messages.MyWriter;
import com.shuvamnandi.multiplethreads.Countdown;
import com.shuvamnandi.multiplethreads.CountdownThread;
import com.shuvamnandi.threads.AnotherThread;
import com.shuvamnandi.threads.MyRunnable;

import static com.shuvamnandi.ThreadColor.*;

public class Main {
    public static void basicThreadExamples() {
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

        new Thread(new MyRunnable() {
            @Override
            public void run() {
                System.out.println(ANSI_CYAN + "Hello from the anonymous class's implementation of run!");
                try {
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

    public static void multipleThreadsExamples() {
        Countdown countdown = new Countdown();
        // No interference if there are separate countdown objects
        // CountdownThread countdownThread1 = new CountdownThread(new Countdown());
        // countdownThread1.setName("Thread-1");
        // CountdownThread countdownThread2 = new CountdownThread(new Countdown());
        // countdownThread1.setName("Thread-2");
        CountdownThread countdownThread1 = new CountdownThread(countdown);
        countdownThread1.setName("Thread-1");
        CountdownThread countdownThread2 = new CountdownThread(countdown);
        countdownThread1.setName("Thread-2");
        countdownThread1.start();
        countdownThread2.start();
    }

    public static void producerConsumerExamples() {
        Message message = new Message();
        MyWriter myWriter = new MyWriter(message);
        MyReader myReader = new MyReader(message);

        (new Thread(myWriter)).start();
        (new Thread(myReader)).start();
    }

    public static void main(String[] args) {
        //basicThreadExamples();
        // multipleThreadsExamples();
        producerConsumerExamples();
    }
}
