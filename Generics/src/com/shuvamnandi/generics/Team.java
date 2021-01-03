package com.shuvamnandi.generics;

import java.util.ArrayList;

public class Team<T extends Player> {
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
            System.out.println(((Player)player).getName() + " is already on this team");
            return false;
        } else {
            this.members.add(player);
            System.out.println(((Player)player).getName()+ " picked for team " + name);
            return true;
        }
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResult(Team opponent, int ourScore, int theirScore) {
        if (ourScore > theirScore) {
            this.won++;
        } else if (ourScore < theirScore) {
            this.lost++;
        } else{
            this.tied++;
        }
        this.played++;
        if(opponent!=null){
            opponent.matchResult(null, theirScore, ourScore);
        }
    }

    public int ranking(){
        return (this.won*3)+this.tied;
    }
}
