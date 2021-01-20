package com.shuvam.learning;

public class SIBTest {
    public static final String owner;

    /*
    Both the static initialization blocks are called before the constructor, and in fact,
    they're called before any non-static methods including the constructor are called.
     */
    static {
        owner = "Shuvam";
        System.out.println("SIBTest static initialisation block called. Owner specified as " + owner);
    }

    public SIBTest() {
        System.out.println("SIBTest constructor called");
    }

    static {
        System.out.println("2nd static initialisation block called. Owner specified as " + owner);
    }

    public void someMethod() {
        System.out.println("Some method called.");
    }
}
