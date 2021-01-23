package com.shuvam.learning;

import java.util.function.Function;
import java.util.function.Supplier;

public class ChallengePart1 {

    public static void challenge1() {
        // Challenge 1
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for(String part: parts) {
                    System.out.println(part);
                }
            }
        };

        Runnable runnableLambda = ()-> {
            String myString = "Let's split this up into an array";
            String[] parts = myString.split(" ");
            for(String part: parts) {
                System.out.println(part);
            }
        };

        new Thread(runnable).start();
        new Thread(runnableLambda).start();
    }

    public static void challenges2And3(String s) {
        // Challenge 2
        /*
        StringBuilder returnVal = new StringBuilder();
        for(int i=0; i<source.length(); i++) {
            if (i%2==0) {
                returnVal.append(i);
            }
        }
        returnVal.toString();
        */
        Function<String, String> lambdaFunction = (source) -> {
            StringBuilder returnVal = new StringBuilder();
            for(int i=0; i<source.length(); i++) {
                if (i%2==0) {
                    returnVal.append(source.charAt(i));
                }
            }
            return returnVal.toString();
        };

        // Challenge 3

        System.out.println("Function run result: " + lambdaFunction.apply(s));
    }

    public static void main(String[] args) {
        challenge1();
        challenges2And3("1234567890");
    }
}
