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

    public static Function challenges2And3(String s) {
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
        System.out.println("Challenge 3 result: " + lambdaFunction.apply(s));
        return lambdaFunction;
    }

    public static String challenge4And5(Function<String, String> function, String inputString) {
        return function.apply(inputString);
    }

    public static String challenge6And7() {
        Supplier<String> iLoveJava = () -> "I love Java";
        String supplierResult = iLoveJava.get();
        return supplierResult;
    }

    public static void main(String[] args) {
        challenge1();
        Function f = challenges2And3("1234567890");
        String result = challenge4And5(f, "1234567890");
        System.out.println("Challenge 4/5 result: " + result);
        result = challenge6And7();
        System.out.println("Challenge 6/7 result: " + result);
    }
}
