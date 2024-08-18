package org.example.address;

/**
 * Класс города
 */
public class City extends Region {

    private final String cityRussia = "Moscow";
    private final String cityUsa = "Washington";
    private final String cityFrance = "Paris";

    public String getCityRussia() {
        return cityRussia;
    }

    public String getCityUsa() {
        return cityUsa;
    }

    public String getCityFrance() {
        return cityFrance;
    }

    @Override
    public String addressRussia() {
        return super.addressRussia() + ", " + cityRussia;
    }

    @Override
    public String addressUsa() {
        return super.addressUsa() + ", " + cityUsa;
    }

    @Override
    public String addressFrance() {
        return super.addressFrance() + ", " + cityFrance;
    }
}
