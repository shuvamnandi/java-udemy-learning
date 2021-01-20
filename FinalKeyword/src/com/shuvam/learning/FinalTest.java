package com.shuvam.learning;

public class FinalTest {
    /*
    Final fields are not actually constants, because they can be modified but only once.
    Any modification must be performed before the class constructor finishes. That means we can assign a
    final field it's value either when we first declare it, or in the constructor.
     */

    /*
    Constants are declared a static final, because if the value really is a constant and won't change,
    then it doesn't make sense to store a copy of that in every single class instance. They all hold the same value
    so it makes sense to store it only once at the class level. e.g. Math.PI
     */
    private static int classCounter = 0;
    public final int instanceNumber; // Each instance of a class will maintain its own instance number value, and since it is final, attempting to change it is not allowed  and give a compile error.
    private final String name;

    public FinalTest(String name) {
        this.name = name;
        classCounter++;
        instanceNumber = classCounter; // this is not allowed if during initialisation the variable is already assigned avalue
        System.out.println(name + " created, instance no. is " + instanceNumber + " " + Math.PI);
    }

    public static int getClassCounter() {
        return classCounter;
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }

    public String getName() {
        return name;
    }
}
