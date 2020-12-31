package com.shuvamnandi;

public class FerrariCar extends Car {
    private int roadServiceMonths;

    public FerrariCar(String colour, String size, String carType, int roadServiceMonths) {
        super(5, 2, 2, 6, "Ferrari", colour, size, carType, false);
        this.roadServiceMonths = roadServiceMonths;
        System.out.println("FerrariCar constructor called");
    }

    public void accelerate(int rate) {
        int newVelocity = getCurrentVelocity() + rate;
        if (newVelocity == 0){
            stop();
            changeGear(1);
        } else if (newVelocity >0 && newVelocity <= 10 ){
            changeGear(1);
        } else if (newVelocity >10 && newVelocity <= 20 ){
            changeGear(2);
        } else if (newVelocity >20 && newVelocity <= 40 ){
            changeGear(3);
        } else if (newVelocity >40 && newVelocity <= 60 ){
            changeGear(4);
        } else if (newVelocity >60 && newVelocity <= 80 ){
            changeGear(5);
        } else {
            changeGear(6);
        }

        if (newVelocity > 0) {
            changeVelocity(newVelocity, getCurrentDirection());
        }
    }
}
