package com.shuvam.learning;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();
        if (languages.containsKey("Java")) {
            System.out.println("Java is already present in the map, not adding a new value");
        }
        else {
            // The old value gets overwritten with a new value if put() is called again with same key and a different value property
            System.out.println(languages.put("Java", "A compiled high level, object-oriented, platform independent language")); // put returns the previous value for same key
            System.out.println("Java added successfully");
        }
        languages.put("Python", "An interpreted, object-oriented, high level programming language with dynamic semantics");
        languages.put("Algol", "An algorithmic language");
        languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness");

        System.out.println(languages.get("Java"));
        if (languages.containsKey("Java")) {
            System.out.println("Java is already present in the map, not adding a new value");
        }
        else {
            // The old value gets overwritten with a new value if put() is called again with same key and a different value property
            System.out.println(languages.put("Java", "this course is about Java")); // put returns the previous value for same key
        }
        System.out.println(languages.get("Java"));

        // Print keys of the HashMap, returns as a Set when keySet() is called
        System.out.println("==============================");
        for(String key: languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }
    }
}
