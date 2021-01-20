package com.shuvamnandi.learning;

public class Main {
    public int multiplier = 7;

    public static void main(String[] args) {
        System.out.println("Number of instances: " + StaticTest.getNumInstances());
        StaticTest firstInstance = new StaticTest("First instance");
        System.out.println("Number of instances: " + StaticTest.getNumInstances());

        StaticTest secondInstance = new StaticTest("Second instance");
        System.out.println("Number of instances: " + StaticTest.getNumInstances());

        StaticTest thirdInstance = new StaticTest("Third instance");
        System.out.println("Number of instances: " + StaticTest.getNumInstances());

        /*
        nUsually, class fields require an instance of the class that don't actually exist until an
        instance has been created. The main method is static and it can be called with the class instance.
        So as a result, Java can't allow a static method to access non-static fields or methods, because
        they don't exist when the static methods get called.
         */
//        int answer = multiply(6);
//        System.out.println("The answer is: " + answer);
//        System.out.println("Multiplier is: " + multiplier);
    }

    public int multiply(int number) {
        return number * multiplier;
    }
}
