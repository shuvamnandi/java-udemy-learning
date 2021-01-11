package com.shuvam.learning;

import java.util.*;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

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
        Map<String, Integer> tempExit = new HashMap<>();

        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));

        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
//        tempExit.put("Q", 0);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));

//        tempExit.put("Q", 0);

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));
//        tempExit.put("Q", 0);

        tempExit = new HashMap<>();
        tempExit.put("N", 1);
        tempExit.put("W", 2);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));
//        tempExit.put("Q", 0);

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", null));
//        tempExit.put("Q", 0);

        int loc = 1;

        while(true) {
            System.out.println(locations.get(loc).getDescription());
            tempExit.remove("Q");
            if (loc==0) {
                break;
            }
            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for(String exit: exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            Map<String, String> vocabulary = new HashMap<>();
            vocabulary.put("QUIT", "Q");
            vocabulary.put("NORTH", "N");
            vocabulary.put("SOUTH", "S");
            vocabulary.put("EAST", "E");
            vocabulary.put("WEST", "W");

            String direction = scanner.nextLine().toUpperCase();
            if (direction.length() > 1) {
                String[] words = direction.split(" ");
                for(String word: words) {
                    if(vocabulary.containsKey(word)) {
                        direction = vocabulary.get(word);
                        break;
                    }
                }
            }
            if(exits.containsKey(direction)) {
                loc = exits.get(direction);
            }
            else {
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
