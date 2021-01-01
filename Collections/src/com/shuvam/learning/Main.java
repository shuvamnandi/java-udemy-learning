package com.shuvam.learning;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        // Write code here
        Theatre theatre = new Theatre("Big", 8, 12 );
        System.out.println(theatre.getTheatreName());
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats);
        printList(seatCopy);
        seatCopy.get(1).reserve(); // reserve A02

        if (theatre.reserveSeat("A02")) {
            System.out.println("Please pay");
        } else {
            System.out.println("Sorry seat is already taken");
        }

        Collections.shuffle(seatCopy);
        printList(seatCopy);
        printList(theatre.seats);

        Theatre.Seat minSeat = Collections.min(seatCopy);
        Theatre.Seat maxSeat = Collections.max(seatCopy);

        System.out.println(minSeat.getSeatNumber());
        System.out.println(maxSeat.getSeatNumber());

        //System.out.println(theatre.getSeats());

//        if (theatre.reserveSeat("H11")) {
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sorry seat is already taken");
//        }
//
//        if (theatre.reserveSeat("H11")) {
//            System.out.println("Please pay");
//        } else {
//            System.out.println("Sorry seat is already taken");
//        }
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat: list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println("");
        System.out.println("================================");

    }

}
