package com.shuvam.learning;

import java.util.*;

public class Main {
    public static void main(String[] args){
        // Write code here
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

}
