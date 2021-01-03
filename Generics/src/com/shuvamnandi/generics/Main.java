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
        FootballPlayer aguero = new FootballPlayer("Aguero");
        FootballPlayer salah = new FootballPlayer("Salah");
        BaseballPlayer pat = new BaseballPlayer("Pat");
        CricketPlayer adam = new CricketPlayer("Adam");

        Team<FootballPlayer> manchesterUnited = new Team<>("Manchester United");
        manchesterUnited.addPlayer(david);
        //adelaideCrows.addPlayer(pat); // not allowed to be added
        //adelaideCrows.addPlayer(adam); // not allowed to be added
        System.out.println("Players in team: " + manchesterUnited.numPlayers());

        Team<FootballPlayer> manchesterCity = new Team<>("Manchester City");
        manchesterCity.addPlayer(aguero);
        System.out.println("Players in team: " + manchesterCity.numPlayers());

        Team<FootballPlayer> liverpool = new Team<>("Liverpool");
        liverpool.addPlayer(salah);
        System.out.println("Players in team: " + liverpool.numPlayers());

        Team<BaseballPlayer> chicagoCubs = new Team<>("Chicago Cubs");
        chicagoCubs.addPlayer(pat);
        //adelaideCrows.addPlayer(adam); // not allowed to be added
        System.out.println("Players in team: " + chicagoCubs.numPlayers());

        Team<CricketPlayer> kolkataKnightRiders = new Team<>("Kolkata Knight Riders");
        kolkataKnightRiders.addPlayer(adam);
        //adelaideCrows.addPlayer(adam); // not allowed to be added
        System.out.println("Players in team: " + kolkataKnightRiders.numPlayers());

        manchesterUnited.matchResult(manchesterCity, 3, 3);
        manchesterCity.matchResult(liverpool, 3, 2);
        liverpool.matchResult(manchesterUnited, 2, 0);
        // manchesterUnited.matchResult(kolkataKnightRiders, 3, 4); // Does not work
        System.out.println(manchesterUnited.getName() + " : " + manchesterUnited.ranking());
        System.out.println(manchesterCity.getName() + " : " + manchesterCity.ranking());
        System.out.println(liverpool.getName() + " : " + liverpool.ranking());

        System.out.println(manchesterUnited.compareTo(manchesterCity));
        System.out.println(manchesterUnited.compareTo(manchesterCity));
        System.out.println(manchesterCity.compareTo(manchesterUnited));
        System.out.println(liverpool.compareTo(manchesterUnited));

        // Team<String> brokenTeam = new Team<>("This won't work");
        // This causes Exception in thread "main" java.lang.ClassCastException:
        // class java.lang.String cannot be cast to class com.shuvamnandi.generics.Player
        // (java.lang.String is in module java.base of loader 'bootstrap';
        // com.shuvamnandi.generics.Player is in unnamed module of loader 'app')
        // brokenTeam.addPlayer("Beckham");

        League<Team<FootballPlayer>> epl = new League<>("English Premier League");
        epl.addTeam(manchesterCity);
        epl.addTeam(manchesterUnited);
        epl.addTeam(liverpool);
        // epl.addTeam(kolkataKnightRiders); // not allowed as only Team<FootballPlayer> is allowed, not Team<CricketPlayer>
        epl.showLeagueTable();

        Team rawTeam = new Team("Raw Team");
        rawTeam.addPlayer(salah);
        rawTeam.addPlayer(david);
        rawTeam.addPlayer(adam);

        epl.addTeam(rawTeam); // Unchecked warning

        League<Team> rawLeague = new League<>("Raw League");
        rawLeague.addTeam(liverpool); // no warning
        rawLeague.addTeam(chicagoCubs); // no warning
        rawLeague.addTeam(rawTeam); // no warning

        League reallyRawLeague = new League("Really Raw League");
        reallyRawLeague.addTeam(manchesterCity); // unchecked warning
        reallyRawLeague.addTeam(kolkataKnightRiders); // unchecked warning
        reallyRawLeague.addTeam(rawTeam); // unchecked warning
    }
}
