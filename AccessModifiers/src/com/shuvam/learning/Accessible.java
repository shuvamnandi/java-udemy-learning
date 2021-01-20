package com.shuvam.learning;

// Whole point of interface is to make other classes implement it, so they need to be private in order for classes
// to actually implement them
// However, we can control where this interface can be allowed for implementation, by not specifying public, which would
// mean that only classes inside the same package can implement this interface

interface Accessible { // package private
    int SOME_CONSTANT = 100; // public, as all variables inside interfaces are public static final
    public void methodA(); // public
    void methodB(); // public, all methods inside interfaces are public by defaulte
    boolean methodC(); // public, all methods inside interfaces are public by defaulte
}
