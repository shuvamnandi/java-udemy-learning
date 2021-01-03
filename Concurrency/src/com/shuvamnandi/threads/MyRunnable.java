package com.shuvamnandi.threads;

import static com.shuvamnandi.ThreadColor.ANSI_PURPLE;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println(ANSI_PURPLE + "Hello from MyRunnable's implementation of run");
    }
}
