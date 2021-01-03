package com.shuvamnandi.multiplethreads;

import com.shuvamnandi.ThreadColor;

public class Countdown {
    public void doCountdown() {
        String color;
        
        switch (Thread.currentThread().getName()) {
            case "Thread-1":
                color = ThreadColor.ANSI_CYAN;
                break;
            case "Thread-2":
                color = ThreadColor.ANSI_GREEN;
                break;
            default:
                color = ThreadColor.ANSI_PURPLE;
        }

        for (int i=10; i>0; i--) {
            System.out.println(color + Thread.currentThread().getName() + " : i= " + i);
        }
    }
}
