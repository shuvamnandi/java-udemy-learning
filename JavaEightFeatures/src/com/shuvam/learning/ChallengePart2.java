package com.shuvam.learning;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Function;

public class ChallengePart2<c> {

    private static List<String> topNames2015 = Arrays.asList(
            "Amelia",
            "Olivia",
            "emily",
            "Isla",
            "Ava",
            "oliver",
            "Jack",
            "Charlie",
            "harry",
            "Jacob"
    );

    public static void challenge8() {
        // Challenge 8
        // Given a specific interface, how can we tell whether we can map a lambda expression to it?
        // What is the criteria to be met?
        /*
        Answer: the interface has to be a Functional Interface. It can only have a single method that
        must be implemented. It can have more than one method, but all the methods but one must have
        default implementations.
        Most of the time, the documentation for an interface will state whether it is a functional interface
         */
        // Runnable & Callable can be implemented using a lambda expression
        Callable<Integer> d = ()-> 5;
    }

    public static void challenge9() {
        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name->
                firstUpperCaseList.add(name.substring(0, 1).toUpperCase()+name.substring(1))
        );
        firstUpperCaseList.sort((s1, s2) -> s1.compareTo(s2));
        firstUpperCaseList.forEach(s->System.out.println(s));
    }

    public static void challenge10() {
        // Use method references
        List<String> firstUpperCaseList = new ArrayList<>();
        topNames2015.forEach(name->
                firstUpperCaseList.add(name.substring(0, 1).toUpperCase()+name.substring(1))
        );
        firstUpperCaseList.sort(String::compareTo);
        firstUpperCaseList.forEach(System.out::println);

    }

    public static void challenge11() {
        // Use Streams
        Function<String, String> toSentenceCase = name ->
                name.substring(0, 1).toUpperCase().concat(name.substring(1));

        topNames2015.stream()
                .map(toSentenceCase)
                .sorted(String::compareTo)
                .forEach(System.out::println);

    }

    public static void challenge12() {
        // Use Streams
        Function<String, String> toSentenceCase = name ->
                name.substring(0, 1).toUpperCase().concat(name.substring(1));

        long namesWithA = topNames2015.stream()
                .map(toSentenceCase)
                .filter(s->s.startsWith("A"))
                .count();

        System.out.println("Count of names starting with A: " + namesWithA);

    }

    public static void main(String[] args) {
        System.out.println("--------------");
        challenge9();
        System.out.println("--------------");
        challenge10();
        System.out.println("--------------");
        challenge11();
        System.out.println("--------------");
        challenge12();
    }
}
