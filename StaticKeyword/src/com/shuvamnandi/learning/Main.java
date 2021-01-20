package com.shuvamnandi.learning;

public class Main {
    public static void main(String[] args) {
        StaticTest firstInstance = new StaticTest("First instance");
        System.out.println("Number of instances: " + StaticTest.getNumInstances());

        StaticTest secondInstance = new StaticTest("Second instance");
        System.out.println("Number of instances: " + StaticTest.getNumInstances());

        StaticTest thirdInstance = new StaticTest("Third instance");
        System.out.println("Number of instances: " + StaticTest.getNumInstances());
    }
}
