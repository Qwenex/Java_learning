package org.example.facadePattern.complexSoup;

/**
 * Вода для супа
 */
public class WaterSoup {

    private String name;
    private Double liters;

    public WaterSoup(String name, Double liters) {
        this.name = name;
        this.liters = liters;
    }

    public String getName() {
        return name;
    }

    public Double getLiters() {
        return liters;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLiters(Double liters) {
        this.liters = liters;
    }

    public void boilWater(Integer time) {}

    @Override
    public String toString() {
        return String.format("\n Вода %s (%s литров)", name, liters);
    }
}
