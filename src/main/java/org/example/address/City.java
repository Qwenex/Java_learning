package org.example.address;

/**
 * Класс города
 */
public class City extends Region {

    private final String city;

    public String getCity() {
        return city;
    }

    public City(String nameCountry, String nameRegion, String nameCity) {
        super(nameCountry, nameRegion);
        this.city = nameCity;
    }

    /**
     * Получение адреса города
     * @return Адрес города
     */
    @Override
    public String getAddress(){
        return super.getAddress() + ", " + city;
    }
}