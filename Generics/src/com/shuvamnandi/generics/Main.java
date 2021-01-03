package com.shuvamnandi.generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static void printDoubled(List<Integer> n) {
        for(int i: n) {
            System.out.println(i*2);
        }
    }

    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>();
        items.add(1);
        items.add(2);
        // error would come up in printDoubled method, which Java cannot detect until runtime
        //items.add("Tim");
        items.add(3);
        items.add(4);
        printDoubled(items);
        FootballPlayer david = new FootballPlayer("Beckham");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        CricketPlayer adam = new CricketPlayer("Adam");

        Team<FootballPlayer> adelaideCrows = new Team<>("Adelaide Crows");
        adelaideCrows.addPlayer(david);
        //adelaideCrows.addPlayer(pat); // not allowed to be added
        //adelaideCrows.addPlayer(adam); // not allowed to be added

        System.out.println("Players in team: " + adelaideCrows.numPlayers());
    }


}
