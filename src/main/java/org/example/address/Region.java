package org.example.address;

/**
 * Класс региона
 */
public class Region extends Country {

    private final String region;

    public String getRegion() {
        return region;
    }

    public Region(String nameCountry, String nameRegion){
        super(nameCountry);
        this.region = nameRegion;
    }

    /**
     * Получение адреса региона
     * @return Адрес региона
     */
    @Override
    public String getAddress(){
        return super.getAddress() + ", " + region;
    }
}