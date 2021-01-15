package com.shuvam.learning;

import java.util.HashSet;
import java.util.Set;

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
    }

    // This method the class makes mutable.
    // This however makes sense, as new bodies are discovered in the solar system constantly.
    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if((obj==null) || (obj.getClass() != this.getClass())) { // Don't return true if obj is a subclass of this class
            return false;
        }
        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    // Above does not yet get called, duplicate planets are still added to our HashSet
    // We need to override the hashCode() too
    // With below override, now duplicate planets (based on name) will not be added

    @Override
    public int hashCode() {
        return this.getName().hashCode() + 76;  // Adding a random number, to make a HeavenlyBody named Pluto should have a different hash code than a String Pluto
    }
}
