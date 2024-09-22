package org.example.bridgePattern;

/**
 * Транспорт
 */
public abstract class Vehicle {

    protected Boolean engineStatus = false;
    protected String driveStatus;

    public Boolean engineStatus() {
        return engineStatus;
    }

    public String engineOn() {
        engineStatus = true;
        return "Двигатель включен";
    }

    public String engineOff() {
        engineStatus = false;
        return "Двигатель выключен";
    }

    public String engineSwitch() {
        if (engineStatus) {
            engineStatus = false;
            return "Двигатель выключен";
        } else {
            engineStatus = true;
            return "Двигатель включен";
        }
    }

    public String drive() {
        if (!engineStatus) {
            return "Движение невозможно. Двигатель выключен!";
        }
        return driveStatus;
    }

    public String parking() {
        engineStatus = false;
        return "";
    }

    abstract public String refuel(Integer value);

}
