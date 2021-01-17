package com.shuvam.learning;

import java.util.HashSet;
import java.util.Set;

public class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;
    private final BodyTypes bodyType;

    protected enum BodyTypes{
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
        this.bodyType = bodyType;
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

    public BodyTypes getBodyType() {
        return bodyType;
    }

    // This method the class makes mutable.
    // This however makes sense, as new bodies are discovered in the solar system constantly.
    public boolean addSatellite(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }

    // Object are considered equal based on name and body type
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof HeavenlyBody) {
            HeavenlyBody theObject = (HeavenlyBody) obj;
            if (this.name.equals(theObject)) {
                return this.bodyType == theObject.getBodyType();
            }
        }
        return false;
    }

    // Above does not yet get called, duplicate planets are still added to our HashSet
    // We need to override the hashCode() too
    // With below override, now duplicate planets (based on name and body type) will not be added

    @Override
    public int hashCode() {
        return this.getName().hashCode() + 76 + this.getBodyType().hashCode();  // Adding a random number, to make a HeavenlyBody named Pluto should have a different hash code than a String Pluto
    }

    @Override
    public String toString() {
        return this.name + ": " + this.bodyType + ", " + this.orbitalPeriod;
    }
}
