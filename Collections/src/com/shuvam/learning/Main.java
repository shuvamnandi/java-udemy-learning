package com.shuvam.learning;

import java.util.*;

public class Main {
    private static Map<Integer, Location> locations = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    private static Map<String, HeavenlyBody> solarSystem = new HashMap<>();
    private static Set<HeavenlyBody> planets = new HashSet<>();

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
        tempExit.equals(tempExit);
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

    public static void setExamples() {
        HeavenlyBody tempPlanet = new Planet("Mercury", 88);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Venus", 225);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Earth", 365);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);

        HeavenlyBody tempMoon = new Planet("Moon", 27);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        tempPlanet = new Planet("Mars", 687);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        tempPlanet = new Planet("Jupiter", 4331);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getName(), tempMoon);
        tempPlanet.addSatellite(tempMoon);

        tempPlanet = new Planet("Saturn", 10747);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Uranus", 30589);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Neptune", 59800);
        solarSystem.put(tempPlanet.getName(), tempPlanet);
        planets.add(tempPlanet);

        tempPlanet = new Planet("Pluto", 90560);
        System.out.println(solarSystem.put(tempPlanet.getName(), tempPlanet));
        planets.add(tempPlanet);

        System.out.println("Planets");
        for (HeavenlyBody planet:planets) {
            System.out.println("\t" + planet.getName());
        }

        HeavenlyBody planet = solarSystem.get("Jupiter");
        System.out.println("Moons of planet: " + planet.getName());
        for (HeavenlyBody moon:planet.getSatellites()) {
            System.out.println("\t" + moon.getName());
        }

        // Union of set of planets of all moons
        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody body: planets) {
            moons.addAll((body.getSatellites()));
        }

        System.out.println("All moons in solar system");
        for (HeavenlyBody moon: moons) {
            System.out.println("\t" + moon.getName() + " with an orbital period of " + moon.getOrbitalPeriod() + " days.");
        }

        // Add in another Pluto
        tempPlanet = new DwarfPlanet("Pluto", 905);
        System.out.println(solarSystem.put(tempPlanet.getName(), tempPlanet));
        planets.add(tempPlanet);

        System.out.println("Planets");
        for (HeavenlyBody p:planets) {
            System.out.println("\t" + p.getName());
        }

        Object o = new Object();
        System.out.println(o.equals(o)); // results true
        System.out.println("pluto".equals("")); // results false

        /*
        The reason that the two Pluto objects don't compare equal is because the base Object class from which all other
        classes are derived just defines a very simple equals method, that performs what is known as referential
        equality, i.e. if both references point to the same object then they are equal, otherwise they are not.
        This is the default equals that comes with the base object class.

        Pluto is getting added twice in the planets HashSet as of now. The reason is that the two java objects for each
        Pluto do not compare equal, so the set is happy to accept both of them for that reason. If we use them as keys
        in a map, the same thing will happen as well, and we will have two entries in a map. This is why the equals method has to be overwritten in our HeavenlyBody.

        If two objects compare equal, then they must have the same hash code --> The hash code determines which
        bucket any object is added into. There is a requirement that any objects that are equal,
        should always had the same hash code and so that they will end up in the same bucket.

        If two objects compare equal, then their hash code must also be the same. That's why one must override
        the hashCode method if you ever override equals in a class. This is to ensure that the two equal objects
        will always generate the same hashCode for bucketing for HashMap storage.

        When we add an object to a HashMap, its hashCode tells the collection which bucket it should go into.
        There may already be objects in that bucket, so each object is compared to the new object to make sure that
        its not already in there. Now because the comparison is performed using the equals method the collection will
        only know if it's already there if it's looking in the right bucket, therefore the hash code must be the same.
        Now it is of no use for equals returning true if the collection is checking the wrong bucket, i.e. if the
        hashCode for the new object is not the same as an object that is that it is equal to.
        Hence for 2 objects equal to each other, their hashCode must also return be the same.
         */
    }

    public static void equalsSubclassingProblems() {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover)); // true as Labrador is an instance of Dog
        System.out.println(rover.equals(rover2)); // false as Dog is not an instance of Labrador

    }
    public static void main(String[] args){
        // mapExamples();
        // adventureGame();
        // setExamples();
        equalsSubclassingProblems();
    }



}
