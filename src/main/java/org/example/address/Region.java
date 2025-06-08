package org.example.address;

/**
 * Класс региона
 */
public class Region extends Country {

    private final String region;

    public Region(String nameCountry, String nameRegion) {
        super(nameCountry);
        this.region = nameRegion;
    }

    public String getRegion() {
        return region;
    }

    /**
     * Получение адреса региона
     * @return Адрес региона
     */
    @Override
    public String getAddress() {
        return super.getAddress() + ", " + region;
    }
}