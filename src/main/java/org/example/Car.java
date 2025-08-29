package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.Objects;

public class Car {

    private static final Logger logger = LoggerFactory.getLogger(Car.class);

    public String brand;
    public String model;
    public Integer year;
    public Integer mileage;
    public Integer price;
    private String sellerName;
    private String sellerContact;

    public Car(String brand, String model, Integer year, Integer mileage, Integer price, String sellerName, String sellerContact) {
        this.brand = brand;
        this.model = model;
        this.year = (year <= LocalDate.now().getYear() && year >= 1900) ? year : -1;
        this.mileage = (mileage > 0 && mileage < 2000000) ? mileage : -1;
        this.price = price >= 5000 ? price : -1;
        this.sellerName = sellerName;
        this.sellerContact = sellerContact;

        if (this.year == -1 || this.mileage == -1 || this.price == -1) {
            logger.info("При добавлении \"{} {}\" одно или несколько полей были заполнены неккоректно.", brand, model);
        }
    }

    private Car() {
        this.brand = "Unknown";
        this.model = "Unknown";
        this.year = -1;
        this.mileage = -1;
        this.price = -1;
        this.sellerName = "Unknown";
        this.sellerContact = "Unknown";
    }

    private Double fastDiscount() {
        if (mileage >= 200000) {
            return price * 0.9;
        } else {
            return price * 0.95;
        }
    }

    public String sellerVisitCard() {
        return sellerName + " / " + sellerContact;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return Objects.equals(brand, car.brand)
                && Objects.equals(model, car.model)
                && Objects.equals(year, car.year)
                && Objects.equals(mileage, car.mileage)
                && Objects.equals(price, car.price)
                && Objects.equals(sellerName, car.sellerName)
                && Objects.equals(sellerContact, car.sellerContact);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, year, mileage, price, sellerName, sellerContact);
    }

    @Override
    public String toString() {
        return String.format("Car{%s %s, %s года, пробег: %s км, цена: %s руб, Продавец: %s, Контакты: %s}",
                brand, model, year, mileage, price, sellerName, sellerContact);
    }
}