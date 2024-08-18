package org.example.address;

/**
 * Класс региона
 */
public class Region extends Country {

    private final String regionRussia = "Moscow Region";
    private final String regionUsa = "District of Columbia";
    private final String regionFrance = "Region Ile-de-France";

    public String getRegionRussia() {
        return regionRussia;
    }

    public String getRegionUsa() {
        return regionUsa;
    }

    public String getRegionFrance() {
        return regionFrance;
    }

    @Override
    public String addressRussia() {
        return super.addressRussia() + ", " + regionRussia;
    }

    @Override
    public String addressUsa() {
        return super.addressUsa() + ", " + regionUsa;
    }

    @Override
    public String addressFrance() {
        return super.addressFrance() + ", " + regionFrance;
    }
}