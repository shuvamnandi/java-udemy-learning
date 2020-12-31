package com.shuvamnandi;

public class Dog extends Animal{
    private static int eyes;
    private int legs;
    private int teeth;
    private int tail;
    private String coat;

    public Dog(String name, int size, int weight, int eyes, int legs, int teeth, int tail, String coat) {
        super(name, 1, 1, size, weight);
        Dog.eyes = eyes;
        this.legs = legs;
        this.teeth = teeth;
        this.tail = tail;
        this.coat = coat;
    }

    private void chew() {
        System.out.println("Dog chews");
    }

    @Override
    public void eat() {
        System.out.println("Dog eats");
        chew();
        super.eat();
    }

    public void walk() {
        System.out.println("Dog walks");
        move(5);
    }

    public void run() {
        System.out.println("Dog runs");
        move(10);
    }

}
