package com.shuvamnandi.innerclasses;

import java.util.ArrayList;

public class Gearbox {
    private ArrayList<Gear> gears;
    private int maxGears;
    private int currentGear = 0;
    private boolean clutchIsIn;

    public Gearbox(int maxGears) {
        this.maxGears = maxGears;
        this.gears = new ArrayList<>();
        Gear neutral = new Gear(0, 0.0);
        this.gears.add(neutral);
        for (int i=1; i<=maxGears; i++) {
            addGear(i, i*5.3);
        }
    }

    public int getCurrentGear() {
        return currentGear;
    }

    public void operateClutch(boolean in) {
        this.clutchIsIn = in;
    }

    public void addGear(int number, double ratio) {
        if(number > 0 && number <= maxGears) {
            System.out.println("Creating a new gear: " + number + " with ratio= " + ratio );
            this.gears.add(new Gear(number, ratio));
        }
    }

    public void changeGear(int newGearNumber) {
        if (newGearNumber > 0 && newGearNumber <= this.gears.size() && this.clutchIsIn ){
            System.out.println("Changing gear to: " + newGearNumber);
            this.currentGear = newGearNumber;
        } else {
            System.out.println("Grind!!!");
            this.currentGear = 0;
        }
    }

    public double wheelSpeed(int revs) {
        if (this.clutchIsIn) {
            System.out.println("Scream!!!");
            return 0.0;
        } else {
            return revs * gears.get(currentGear).getRatio();
        }
    }

    // Usually inner classes would be private and constructed only by outer class
    private class Gear {
        private int gearNumber = 0;
        private double ratio;

        public Gear(int gearNumber, double ratio) {
            this.gearNumber = gearNumber;
            this.ratio = ratio;
        }

        public double driveSpeed(int revs) {
            return revs * this.ratio;
        }

        public double getRatio() {
            return ratio;
        }
    }
}
