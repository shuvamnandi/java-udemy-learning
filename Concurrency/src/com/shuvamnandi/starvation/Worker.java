package com.shuvamnandi.starvation;

import java.util.concurrent.locks.ReentrantLock;

public class Worker implements Runnable {
    private int runCount = 1;
    private String threadColor;
    private ReentrantLock lock;

    public Worker(String threadColor, ReentrantLock lock) {
        this.threadColor = threadColor;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i=0; i<100; i++) {
            lock.lock();
            try{
                System.out.format(threadColor + "%s: runCount = %d\n", Thread.currentThread().getName(), runCount++);
            } finally {
                lock.unlock();
            }
        }
    }
}
