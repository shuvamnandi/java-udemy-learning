package com.shuvamnandi.multiplethreads;

import com.shuvamnandi.ThreadColor;

public class Countdown {
    private int i;

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

        for (this.i=10; this.i>0; this.i--) {
            System.out.println(color + Thread.currentThread().getName() + " : i= " + i);
        }
    }
}
