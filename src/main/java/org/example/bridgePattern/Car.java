package org.example.bridgePattern;

public class Car extends Vehicle {

    @Override
    public String drive() {
        driveStatus = "Автомобиль совершает движение";
        return super.drive();
    }

    @Override
    public String parking() {
        return super.parking() + "Автомобиль припаркован";
    }

    @Override
    public String refuel(Integer liters) {
        return new GasStation().refuel(liters);
    }
}
