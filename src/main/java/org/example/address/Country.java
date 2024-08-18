package org.example.address;

/**
 * Класс страны
 */
public class Country {

    private final String country;

    public String getCountry() {
        return country;
    }

    public Country(String nameCountry){
        this.country = nameCountry;
    }

    /**
     * Получение адреса страны
     * @return Адрес страны
     */
    public String getAddress(){
        return country;
    }
}