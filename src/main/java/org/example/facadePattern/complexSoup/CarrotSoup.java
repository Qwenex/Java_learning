package org.example.facadePattern.complexSoup;

/**
 * Морковь для супа
 */
public class CarrotSoup {

    private String name;
    private Integer value;

    public CarrotSoup(String name, Integer value) {
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

    public void cutCarrot() {};

    public void cookCarrot(Integer time) {}

    @Override
    public String toString() {
        return String.format("\n Морковь %s (%s)", name, value);
    }
}
