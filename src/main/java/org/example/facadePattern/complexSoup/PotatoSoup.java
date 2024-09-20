package org.example.facadePattern.complexSoup;

/**
 * Картофель для супа
 */
public class PotatoSoup {

    private String name;
    private Integer value;

    public PotatoSoup(String name, Integer value) {
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

    public void cutPotato() {};

    public void cookPotato(Integer time) {}

    @Override
    public String toString() {
        return String.format("\n Картофель %s (%s)", name, value);
    }
}
