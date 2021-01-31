package com.shuvam.learning;

public class BiCounter {
    private int i = 0;
    private int j = 0;

    synchronized public void incrementI() {
        System.out.println("Increment i");
        i++;
    }

    synchronized public void incrementJ() {
        System.out.println("Increment j");
        j++;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }
}
