package com.shuvamnandi.learning;

public class Main {
    public static void main(String[] args) {
        StaticTest firstInstance = new StaticTest("First instance");
        System.out.println("Number of instances: " + firstInstance.getNumInstances());

        StaticTest secondInstance = new StaticTest("Second instance");
        System.out.println("Number of instances: " + secondInstance.getNumInstances());

        StaticTest thirdInstance = new StaticTest("Third instance");
        System.out.println("Number of instances: " + thirdInstance.getNumInstances());
    }
}
