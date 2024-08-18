package org.example.address;

/**
 * Класс страны
 */
public class Country {

    private final String countryRussia = "Russia";
    private final String countryUsa = "USA";
    private final String countryFrance = "France";

    public String getCountryRussia() {
        return countryRussia;
    }

    public String getCountryUsa() {
        return countryUsa;
    }

    public String getCountryFrance() {
        return countryFrance;
    }

    public String addressRussia (){
        return countryRussia;
    }

    public String addressUsa (){
        return countryUsa;
    }

    public String addressFrance (){
        return countryFrance;
    }
}