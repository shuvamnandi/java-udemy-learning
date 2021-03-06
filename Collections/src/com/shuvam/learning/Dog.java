package com.shuvam.learning;

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    // Adding final flag to equals prevents subclasses to override equals method
    @Override
    public final boolean equals(Object obj) {
        if (this == obj){
            return true;
        }
        if (obj instanceof Dog) {
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        }
        return false;
    }
}
