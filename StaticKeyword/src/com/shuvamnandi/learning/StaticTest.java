package com.shuvamnandi.learning;

public class StaticTest {
    /*
    A static field which is also known as a class variable is associated with the class rather than with any
    particular instance of it, so it has only one copy of the variable in memory. All instances of the class
    share that one class variable.
    A static method cannot access non-static variables, but an object can access static variables
     */
    private static int numInstances = 0;
    private String name;

    public StaticTest(String name) {
        this.name = name;
        numInstances++;
    }

    public static int getNumInstances() {
        // A static method cannot access non-static variables, but an object can access static variables
        // this keyword is not applicable inside a static context
        // System.out.println("Printing the name: " + this.name);
        return numInstances;
    }

    public String getName() {
        System.out.println("Printing the number of instances: "+numInstances);
        return name;
    }
}
