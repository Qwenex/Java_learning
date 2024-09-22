package org.example.bridgePattern;

public class ElectricCar extends Vehicle {

    @Override
    public String drive() {
        driveStatus = "Электроавтомобиль совершает движение";
        return super.drive();
    }

    @Override
    public String parking() {
        return super.parking() + "Электроавтомобиль припаркован";
    }

    @Override
    public String refuel(Integer MAh) {
        return new ElectricStation().refuel(MAh);
    }
}
