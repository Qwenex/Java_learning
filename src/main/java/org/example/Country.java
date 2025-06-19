package org.example;

import java.util.Objects;

public class Country {

    private String name;
    private Integer area;
    private Integer population;

    public Country(String name, Integer area, Integer population) {
        this.name = name;
        this.area = area;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    /**
     * Получение плотности населения
     * @return Плотность населения
     */
    public Double getDensity() {
        return this.population.doubleValue() / this.area.doubleValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, area, population);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country = (Country) o;
        return Objects.equals(name, country.name) && Objects.equals(area, country.area); // Т.к. население страны динамично, в equals не используется
    }

    @Override
    public String toString() {
        return String.format("\nСтрана %s имеет площадь в %sкм и население в %s человек.", name, area, population);
    }
}
