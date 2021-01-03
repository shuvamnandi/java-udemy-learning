package com.shuvamnandi.generics;

import java.util.ArrayList;

// T can also be implementing an Interface
public class Team<T extends Player> implements Comparable<Team<T>>{
    private String name;
    private int played = 0;
    private int won = 0;
    private int lost = 0;
    private int tied = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if (this.members.contains(player)) {
            System.out.println(player.getName() + " is already on this team");
            return false;
        } else {
            this.members.add(player);
            System.out.println(player.getName()+ " picked for team " + name);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team<T> opponent, int ourScore, int theirScore) {
        String message;
        if (ourScore > theirScore) {
            this.won++;
            message = " beat ";
        } else if (ourScore < theirScore) {
            this.lost++;
            message = " lost to ";
        } else {
            this.tied++;
            message = " drew with ";
        }
        this.played++;
        if (opponent!=null) {
            System.out.println(this.getName() + message + opponent.getName());
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int points() {
        return (this.won*3)+this.tied;
    }

    // Helpful to have compareTo method implemented
    // to perform sort on an ArrayList<Team> variable using Collections.sort
    @Override
    public int compareTo(Team<T> team) {
        if (this.points() > team.points()) {
            return -1;
        } else if (this.points() < team.points()) {
            return 1;
        }
        return 0;
    }
}
