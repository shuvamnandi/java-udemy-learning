package com.shuvam.learning;

import java.util.*;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();

    public static void mapExamples() {
        Theatre theatre = new Theatre("Big", 8, 12 );
        System.out.println(theatre.getTheatreName());

        if (theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Sorry D12 seat is already taken");
        }

        printList(theatre.getSeats());

        if (theatre.reserveSeat("D12")) {
            System.out.println("Please pay for D12");
        } else {
            System.out.println("Sorry D12 seat is already taken");
        }

        if (theatre.reserveSeat("B13")) {
            System.out.println("Please pay for B13");
        } else {
            System.out.println("Sorry B13 seat is already taken");
        }

        List<Theatre.Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Theatre.Seat> priceOrderedSeats = new ArrayList<>(theatre.getSeats());
        priceOrderedSeats.add(theatre.new Seat("B00", 13.00));
        priceOrderedSeats.add(theatre.new Seat("A00", 13.00));
        Collections.sort(priceOrderedSeats, Theatre.PRICE_ORDER);
        printList(priceOrderedSeats);
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat: list) {
            System.out.print(" " + seat.getSeatNumber() + "@" + seat.getPrice());
        }
        System.out.println("");
        System.out.println("================================");
    }

    public static void adventureGame() {
        Scanner scanner = new Scanner(System.in);

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location(2, "You are at the top of a hill"));
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location(4, "You are in a valley beside a stream"));
        locations.put(5, new Location(5, "You are in the forest"));

        int loc = 1;

        while(true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc==0) {
                break;
            }
            loc = scanner.nextInt();
            if(!locations.containsKey(loc)) {
                System.out.println("You cannot go in that direction");
            }
        }
    }

    public static void main(String[] args){
        // Write code here
        // mapExamples();
        adventureGame();
    }



}
