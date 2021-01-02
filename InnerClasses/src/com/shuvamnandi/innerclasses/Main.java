package com.shuvamnandi.innerclasses;

public class Main {
    public static void main(String[] args){
        Gearbox gearbox = new Gearbox(6);
        Gearbox.Gear first = gearbox.new Gear(1, 12.2);
        // Gearbox.Gear first = new Gearbox.Gear(1, 12.3); // works if Gear is a static inner class nested within Gearbox
        // Gearbox.Gear second = new Gearbox.Gear(2, 15.3); // does not work
        Gearbox.Gear second = gearbox.new Gear(2, 15.3);
        // Gearbox.Gear third = new gearbox.Gear(3, 17.8); // does not work
        Gearbox.Gear third = gearbox.new Gear(3, 17.8);

        System.out.println("Speed: " + first.driveSpeed(1000));
        System.out.println("Speed: " + second.driveSpeed(1000));
        System.out.println("Speed: " + third.driveSpeed(1000));
    }
}
