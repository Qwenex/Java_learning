package org.example.address;

/**
 * Класс улицы
 */
public class Street extends City {

    private final String streetRussia = "Lenina st.";
    private final String streetUsa = "Pennsylvania Avenue NW";
    private final String streetFrance = "Pl. Jacques Rueff";

    public String getStreetRussia() {
        return streetRussia;
    }

    public String getStreetUsa() {
        return streetUsa;
    }

    public String getStreetFrance() {
        return streetFrance;
    }

    @Override
    public String addressRussia() {
        return super.addressRussia() + ", "+ streetRussia;
    }

    @Override
    public String addressUsa() {
        return super.addressUsa() + ", "+ streetUsa;
    }

    @Override
    public String addressFrance() {
        return super.addressFrance() + ", "+ streetFrance;
    }
}
