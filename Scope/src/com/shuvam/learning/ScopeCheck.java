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
        // int privateVar = 2; // if this is committed, privateVar from Class is used
        // If this method was a static method, privateVar cannot be accessed from within this method as it is not defined as static
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times 2 is " + i * privateVar);
        }
        // System.out.println("Value of i is" + i); // This does not work, i is not available in this scope
    }

    public class InnerClass {
        public int privateVar = 3; // if this is commented out, it uses privateVar from ScopeCheck, which has a value of 1

        public InnerClass() {
            System.out.println("InnerClass created, privateVar is " + privateVar);
        }

        public void timesTwo() {
            for (int i = 0; i < 10; i++) {
                // ScopeCheck.this.timesTwo(); // call method defined inside ScopeCheck class's object (since it is not a static method, we need to use this keyword)
                // System.out.println(i + " times 3 is " + i * ScopeCheck.this.privateVar); // Access the privateVar defined inside ScopeCheck class
                System.out.println(i + " times 3 is " + i * this.privateVar); // This causes an issue as privateVar is not declared inside the InnerClass scope
            }
        }

    }

}
