package com.shuvam.learning;

import java.util.*;

public class Main {
    public static void main(String[] args){
        // Write code here
        Theatre theatre = new Theatre("Big", 8, 12 );
        System.out.println(theatre.getTheatreName());
        List<Theatre.Seat> seatCopy = new ArrayList<>(theatre.seats); // create a shallow copy of the theatre.seats
        /*
        Shallow copy creates an array list containing all the elements from the list that were passed to the
        constructor. It's very important here to know that these aren't copied, hence the term shallow copy.
         */
        printList(seatCopy);
        seatCopy.get(1).reserve(); // reserve A02

        if (theatre.reserveSeat("A02")) {
            System.out.println("Please pay for A02"); // this does not print
        } else {
            System.out.println("Sorry A02 seat is already taken");
            // this prints, as seatCopy had already reserved the reference to A02 seat object
        }

        // Examples of Collections List Methods
        Collections.shuffle(seatCopy); // Pseudo-randomisation of the list
        System.out.println("Printing copy of theatre.seats");
        printList(seatCopy);
        System.out.println("Printing original theatre.seats");
        printList(theatre.seats);

        Theatre.Seat minSeat = Collections.min(seatCopy); // Based on compareTo method implementation
        Theatre.Seat maxSeat = Collections.max(seatCopy); // Based on compareTo method implementation

        System.out.println("Minimum seat number is: " + minSeat.getSeatNumber());
        System.out.println("Maximum seat number is: " + maxSeat.getSeatNumber());

        // System.out.println(theatre.getSeats());

        // if (theatre.reserveSeat("H11")) {
        //     System.out.println("Please pay");
        // } else {
        //     System.out.println("Sorry seat is already taken");
        // }

        // if (theatre.reserveSeat("H11")) {
        //     System.out.println("Please pay");
        // } else {
        //      System.out.println("Sorry seat is already taken");
        // }
        sortList(seatCopy);
        System.out.println("Printing copy of theatre.seats");
        printList(seatCopy);

        // Deep copy is a copy where the elements are not just references to the same elements as in the
        // original list, but are themselves copied.

        List<Theatre.Seat> newList = new ArrayList<>(theatre.seats.size());
        Collections.copy(newList, theatre.seats); // newList only has capacity same as theatre.seats, but its not initialised yet. Hence this copy does not work.
    }

    public static void printList(List<Theatre.Seat> list) {
        for (Theatre.Seat seat: list) {
            System.out.print(" " + seat.getSeatNumber());
        }
        System.out.println("");
        System.out.println("================================");
    }

    public static void sortList(List<? extends Theatre.Seat> list) {
        for(int i=0; i< list.size()-1; i++) {
            for(int j=i+1; j<list.size(); j++) {
                if(list.get(i).compareTo(list.get(j)) >0) {
                    Collections.swap(list, i, j);
                }
            }
        }

    }

}
