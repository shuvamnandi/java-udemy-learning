package com.shuvam.learning.heavenlybody;

import com.shuvam.learning.heavenlybody.HeavenlyBody;

public class DwarfPlanet extends HeavenlyBody {
    public DwarfPlanet(String name, double orbitalPeriod) {
        super(name, orbitalPeriod, BodyTypes.DWARF_PLANET);
    }
}
