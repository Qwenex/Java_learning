package org.example.bridgePattern;

public class Truck extends Vehicle {

    @Override
    public String drive() {
        driveStatus = "Грузовик совершает движение";
        return super.drive();
    }

    @Override
    public String parking() {
        return super.parking() + "Грузовик припаркован";
    }

    @Override
    public String refuel(Integer liters) {
        return new DieselStation().refuel(liters);
    }
}
