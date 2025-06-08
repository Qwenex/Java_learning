package org.example.address;

/**
 * Класс страны
 */
public class Country {

    private final String country;

    public Country(String nameCountry) {
        this.country = nameCountry;
    }

    public String getCountry() {
        return country;
    }

    /**
     * Получение адреса страны
     * @return Адрес страны
     */
    public String getAddress() {
        return country;
    }
}