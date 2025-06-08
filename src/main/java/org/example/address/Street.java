package org.example.address;

/**
 * Класс улицы
 */
public class Street extends City {

    private final String street;

    public Street(String nameCountry, String nameRegion, String nameCity, String street) {
        super(nameCountry, nameRegion, nameCity);
        this.street = street;
    }

    public String getStreet() {
        return street;
    }

    /**
     * Получение адреса улицы
     * @return Адрес улицы
     */
    @Override
    public String getAddress() {
        return super.getAddress() + ", " + street;
    }
}
