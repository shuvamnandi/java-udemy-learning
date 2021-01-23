package com.shuvam.learning.heavenlybody;

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public enum BodyTypes{
        STAR,
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }

    public Key getKey() {
        return key;
    }

    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(satellites);
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
            return this.key.equals(theObject.getKey());
        }
        return false;
    }

    // Above does not yet get called, duplicate planets are still added to our HashSet
    // We need to override the hashCode() too
    // With below override, now duplicate planets (based on name and body type) will not be added

    @Override
    public int hashCode() {
        return this.getKey().hashCode();  // Adding a random number, to make a HeavenlyBody named Pluto should have a different hash code than a String Pluto
    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public String toString() {
        return this.key.getName() + ": " + this.key.getBodyType() + ", " + this.orbitalPeriod;
    }

    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        public Key(String name, BodyTypes bodyType) {
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 76 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if (this.name.equals(key.getName())) {
                return this.bodyType == key.getBodyType();
            }
            return false;
        }

        @Override
        public String toString() {
            return this.getName() + ": " + this.getBodyType();
        }
    }
}
