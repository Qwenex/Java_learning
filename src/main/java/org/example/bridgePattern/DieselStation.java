package org.example.bridgePattern;

public class DieselStation implements RefuelStation {

    public String refuel(Integer value) {
        return String.format("Грузовик заправлен дизелем на %s литров", value);
    }
}
