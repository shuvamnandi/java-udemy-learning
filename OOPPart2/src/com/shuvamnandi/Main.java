package com.shuvamnandi;

import com.shuvamnandi.composition.*;
import com.shuvamnandi.encapsulation.*;
import com.shuvamnandi.polymorphism.*;
import com.shuvamnandi.oopfinalchallenge.*;

class Movie {
    private String name;

    public Movie(String name){
        this.name = name;
    }

    public String plot() {
        return "No plot here";
    }

    public String getName(){
        return this.name;
    }
}

class Jaws extends Movie {

    public Jaws() {
        super("Jaws");
    }

    public String plot() {
        return "A shark eats lots of people";
    }
}

class IndependenceDay extends Movie {

    public IndependenceDay() {
        super("Independence Day");
    }

    public String plot() {
        return "Aliens attempt to take over planet Earth";
    }
}

class MazeRunner extends Movie {

    public MazeRunner() {
        super("Maze Runner");
    }

    public String plot() {
        return "Kids try and escape a maze";
    }
}

class StarWars extends Movie {

    public StarWars() {
        super("Star Wars");
    }

    public String plot() {
        return "Imperial Forces try to take over the Universe";
    }
}

class Forgettable extends Movie {
    public Forgettable() {
        super("Forgettable");
    }

    // No plot override here
}

public class Main {
    public static void compositionExamples() {
        Case theCase = new Case("220B", "Dell", "240", new Dimensions(20, 20, 5));
        Monitor theMonitor = new Monitor("27inch Beast", "Acer", 27, new Resolution(2540, 1440));
        Motherboard theMotherboard = new Motherboard( "BJ-200", "Asus",4, 6, "2.44");
        PC pc = new PC(theCase, theMotherboard, theMonitor);
        pc.powerUp();

        Wall wall1 = new Wall("West");
        Wall wall2 = new Wall("South");
        Wall wall3 = new Wall("East");
        Wall wall4 = new Wall("North");

        Ceiling ceiling  = new Ceiling(12, 128 );
        Bed bed = new Bed("King", 2, 1, 7, 30);
        Lamp lamp = new Lamp("IKEA", true, 1);
        Bedroom bedroom = new Bedroom("Shuvams bedroom", wall1, wall2, wall3, wall4, ceiling, bed, lamp);
        bedroom.makeBed();
        bedroom.getLamp().turnOn();
    }

    public static void encapsulationExamples() {
        Player player = new Player();
        player.name = "Time";
        player.health = 20;
        player.weapon = "Sword";

        player.loseHealth(10);
        System.out.println("Remaining health: " + player.healthRemaining());
        player.loseHealth(11);
        System.out.println("Remaining health: " + player.healthRemaining());

        EnhancedPlayer enhancedPlayer = new EnhancedPlayer("Tim", 100, "Blade");
        enhancedPlayer.loseHealth(10);
        System.out.println("Remaining health: " + enhancedPlayer.healthRemaining());
        enhancedPlayer.loseHealth(91);
        System.out.println("Remaining health: " + enhancedPlayer.healthRemaining());

        Printer printer = new Printer(100, true);
        System.out.println("Initial page count=" + printer.getPagesPrinted());
        System.out.println("Pages printed=" + printer.printPages(4));
        System.out.println("Pages printed till date count=" + printer.getPagesPrinted());
        System.out.println("Pages printed=" + printer.printPages(5));
        System.out.println("Pages printed till date count=" + printer.getPagesPrinted());
    }

    public static Movie randomMovie() {
        int randomNumber = (int) (Math.random() * 5) + 1;
        System.out.println("Random number generated was: " + randomNumber);
        switch (randomNumber) {
            case 1: return new Jaws();
            case 2: return new IndependenceDay();
            case 3: return new MazeRunner();
            case 4: return new StarWars();
            case 5: return new Forgettable();
        }
        return null;
    }

    public static void polymorphismExamples() {
        for (int i=1;i<11;i++){
            Movie movie = randomMovie();
            System.out.println("Movie name: " + movie.getName() + ". Movie plot: " + movie.plot());
        }

        Car car = new Car(8, "Base car");
        System.out.println(car.startEngine());
        System.out.println(car.accelerate());
        System.out.println(car.brake());

        Mitsubishi mitsubishi = new Mitsubishi(8, "Mitsubishi car");
        System.out.println(mitsubishi.startEngine());
        System.out.println(mitsubishi.accelerate());
        System.out.println(mitsubishi.brake());

        Ford ford = new Ford(12, "Ford car");
        System.out.println(ford.startEngine());
        System.out.println(ford.accelerate());
        System.out.println(ford.brake());

        Holden holden = new Holden(6, "Holden car");
        System.out.println(holden.startEngine());
        System.out.println(holden.accelerate());
        System.out.println(holden.brake());
    }

    public static void finalChallenge(){
        Hamburger hamburger = new Hamburger("Basic", "Chicken",5.6,"Sourdough");
        hamburger.addHamburgerAddition1("Tomato", 0.25);
        hamburger.addHamburgerAddition2("Lettuce", 0.15);
        hamburger.addHamburgerAddition3("Carrot", 0.1);
        hamburger.addHamburgerAddition4("Cheese", 0.5);

        HealthyBurger healthyBurger = new HealthyBurger("Bacon", 7.2 );
        healthyBurger.addHamburgerAddition1("Tomato", 0.25);
        healthyBurger.addHamburgerAddition2("Lettuce", 0.15);
        healthyBurger.addHamburgerAddition3("Carrot", 0.1);
        healthyBurger.addHamburgerAddition4("Cheese", 0.5);
        healthyBurger.addHealthyAddition1("Egg", 1);
        healthyBurger.addHealthyAddition2("Lentils", 0.8);
        System.out.println("Total burger price is : " + healthyBurger.itemizeHamburger());

        DeluxeBurger deluxeBurger = new DeluxeBurger();
        deluxeBurger.itemizeHamburger();
        deluxeBurger.addHamburgerAddition1("Lentils", 0.8);
        System.out.println("Total burger price is : " + deluxeBurger.itemizeHamburger());
    }

    public static void main(String[] args) {
         // compositionExamples();
        // encapsulationExamples();
        // polymorphismExamples();
         finalChallenge();
    }
}
