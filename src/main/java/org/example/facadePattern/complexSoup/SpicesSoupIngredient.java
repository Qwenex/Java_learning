package org.example.facadePattern.complexSoup;

/**
 * Специи для супа
 */
public class SpicesSoupIngredient {

    private String name;
    private Integer value;

    public SpicesSoupIngredient(String name, Integer value) {
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

    public void addSpices() {
    }

    @Override
    public String toString() {
        return String.format("\n Спция %s (%s)", name, value);
    }
}
