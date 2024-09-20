package org.example.facadePattern.complexSoup;

/**
 * Макароны для супа
 */
public class PastaSoup {

    private String name;
    private Integer value;

    public PastaSoup(String name, Integer value) {
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

    public void cookPasta(Integer time) {}

    @Override
    public String toString() {
        return String.format("\n Макароны: %s (%s)", name, value);
    }
}
