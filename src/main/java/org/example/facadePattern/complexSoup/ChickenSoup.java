package org.example.facadePattern.complexSoup;

/**
 * Курица для супа
 */
public class ChickenSoup {

    private String name;
    private Integer value;

    public ChickenSoup(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Integer getValue() {
        return value;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void cutChicken() {};

    public void cookChicken(Integer time) {}

    @Override
    public String toString() {
        return String.format("\n Курица %s (%s)", name, value);
    }
}
