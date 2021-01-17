package com.shuvam.learning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i = 1;i<=100; i++){
            squares.add(i*i);
            cubes.add(i*i*i);
        }

        System.out.println("There are: " + squares.size() + " squares and " + cubes.size());
        // Create a new set as set bulk operations are destructive
        // Union
        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements.");

        // Intersection
        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        System.out.println("Intersection contains " + intersection.size() + " elements.");

        for(int i: intersection) {
            System.out.println(i  + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String [] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));
        printSet(words);

        // Asymmetric difference illustration (prep work)
        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();
        String[] natureWords = "all nature is but art unknown to thee".split(" ");
        nature.addAll(Arrays.asList(natureWords));
        String[] divineWords = "to err is human to forgive divine".split(" ");
        divine.addAll(Arrays.asList(divineWords));

        // Asymmetric difference
        System.out.println("Nature - Divine");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("Divine - Nature");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

        // Symmetric difference
        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symmetric difference");
        unionTest.removeAll(intersectionTest);
        printSet(unionTest);

        // check whether a set is a super set of another or not
        if (nature.containsAll(divine)) {
            System.out.println("divine is a subset of nature");
        }

        if (nature.containsAll(intersectionTest)) {
            System.out.println("intersectionTest is a subset of nature");
        }

        if (divine.containsAll(intersectionTest)) {
            System.out.println("intersectionTest is a subset of divine");
        }
    }

    public static void printSet(Set<String> set) {
        for(String s: set) {
            System.out.print(s+ " ");
        }
        System.out.println("");
    }
}
