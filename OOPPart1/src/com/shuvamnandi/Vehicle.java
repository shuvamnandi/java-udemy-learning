package com.shuvamnandi;

public class Vehicle {
    private int seats;
    private String model;
    private String size;
    private String colour;

    private int currentVelocity;
    private int currentDirection;

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public int getCurrentVelocity() {
        return currentVelocity;
    }

    public void setCurrentVelocity(int currentVelocity) {
        this.currentVelocity = currentVelocity;
    }

    public int getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(int currentDirection) {
        this.currentDirection = currentDirection;
    }

    public Vehicle(int seats, String model, String size, String colour){
        System.out.println("Vehicle constructor called");
        this.seats = seats;
        this.model = model;
        this.size = size;
        this.colour = colour;
        this.currentVelocity = 0;
        this.currentDirection = 0;
    }

    public void steer(int direction) {
        this.currentDirection += direction;
        System.out.println("Vehicle steers at " + this.currentDirection + " degrees.");
    }

    public void move(int velocity, int direction) {
        this.currentVelocity = velocity;
        this.currentDirection = direction;
        System.out.println("Vehicle moves with velocity " + this.currentVelocity + " at " + this.currentDirection + " degrees.");
    }

    public void stop() {
        this.currentVelocity = 0;
    }
}
