package com.shuvamnandi.starvation;

public class Worker implements Runnable {
    private int runCount = 1;
    private String threadColor;
    private Object lock;

    public Worker(String threadColor, Object lock) {
        this.threadColor = threadColor;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            synchronized (lock) {
                System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
            }
        }
    }
}
