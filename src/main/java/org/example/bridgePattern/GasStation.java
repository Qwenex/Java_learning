package org.example.bridgePattern;

public class GasStation implements RefuelStation {

    public String refuel(Integer value) {
        return String.format("Машина заправлена бензином на %s литров", value);
    }
}