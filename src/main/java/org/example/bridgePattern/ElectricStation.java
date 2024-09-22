package org.example.bridgePattern;

public class ElectricStation implements RefuelStation {

    public String refuel(Integer value) {
        return String.format("Электрокар заряжен на %s Mah", value);
    }
}
