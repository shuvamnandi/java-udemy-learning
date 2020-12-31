package com.shuvamnandi;

public class Car extends Vehicle {
    private String carType;
    private int wheels;
    private int doors;
    private int gears;
    private int currentGear;
    private boolean isManual;

    public Car(int wheels, int doors, int seats, int gears, String model, String colour, String size, String carType, boolean isManual) {
        super(seats, model, colour, size);
        this.wheels = wheels;
        this.doors = doors;
        this.gears = gears;
        this.carType = carType;
        this.isManual = isManual;
        this.currentGear = currentGear;
        System.out.println("Car constructor called");
    }

    public void changeGear(int currentGear){
        this.currentGear = currentGear;
        System.out.println("Car changing gear to: " + this.currentGear);
    }

    public void changeVelocity(int velocity, int direction){
        move(velocity, direction);
        System.out.println("Vehicle moves with velocity " + velocity + " at " + direction + " degrees.");
    }

}
