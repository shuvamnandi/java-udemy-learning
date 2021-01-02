package com.shuvamnandi.innerclasses;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnPrint = new Button("Print");
    private static Button btnSubmit = new Button("Submit");

    public static void main(String[] args){
        Gearbox gearbox = new Gearbox(6);
        System.out.println("Current gear: " + gearbox.getCurrentGear());
        gearbox.operateClutch(true);
        gearbox.changeGear(2);
        System.out.println("Current gear: " + gearbox.getCurrentGear());
        System.out.println("Speed: " + gearbox.wheelSpeed(1000));
        gearbox.operateClutch(false);
        System.out.println("Current gear: " + gearbox.getCurrentGear());
        System.out.println("Speed: " + gearbox.wheelSpeed(1000));
        gearbox.changeGear(3);

        class ClickListener implements Button.OnClickListener {
            public ClickListener() {
                System.out.println("I've been attached");
            }

            @Override
            public void onClick(String title) {
                System.out.println(title + " button was clicked");
            }
        }
        btnPrint.setOnClickListener(new ClickListener());
        btnSubmit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " button was clicked");
            }
        });
        listen();
    }

    public static void listen() {
        boolean quit = false;
        while (!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch(choice){
                case 0: quit = true;
                        break;
                case 1: btnPrint.onClick();
                        btnSubmit.onClick();
            }
        }
    }
}
