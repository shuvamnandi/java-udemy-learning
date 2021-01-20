package com.shuvam.learning;

public class FinalTest {
    /*
    Final fields are not actually constants, because they can be modified but only once.
    Any modification must be performed before the class constructor finishes. That means we can assign a
    final field it's value either when we first declare it, or in the constructor.
     */
    private final int instanceNumber = 1;

    public FinalTest() {
        // instanceNumber = 2; // this is not allowed if during initialisation the variable is already assigned avalue
    }


}
