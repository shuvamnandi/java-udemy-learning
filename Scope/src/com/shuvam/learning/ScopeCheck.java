package com.shuvam.learning;

public class ScopeCheck {
    public int publicVar = 0;
    private int privateVar = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = "+publicVar + ": privateVar = " + privateVar);
    }

    public int getPrivateVar() {
        return privateVar;
    }

    public void timesTwo() {
        int privateVar = 2; // if this is committed, privateVar from Class is used
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times 2 is " + i * privateVar);
        }
        // System.out.println("Value of i is" + i); // This does not work, i is not available in this scope
    }

}
