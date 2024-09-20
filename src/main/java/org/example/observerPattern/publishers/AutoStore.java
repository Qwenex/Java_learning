package org.example.observerPattern.publishers;

import org.example.observerPattern.subscribers.Subscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * Магазин автомобилей
 */
public class AutoStore implements Publisher {

    private String name;
    private Integer value;
    private Integer price;
    private final List<Subscriber> subscribersAutoStore;

    public AutoStore(String name, Integer value, Integer price) {
        this.name = name;
        this.value = value;
        this.price = price;
        subscribersAutoStore = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        notification(String.format("Товар \"%s\" изменил свое название на \"%s\"", getName(), name));
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        if (value > getValue()) {
            notification(String.format("Новое пополнение товара: \"%s\"! Количество: %s ед.", this.name, value));
        }
        this.value = value;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        notification(String.format("Изменение цены на товар \"%s\"! Старая цена: %s, Новая цена: %s", this.name, getPrice(), price));
        this.price = price;
    }

    @Override
    public void subscribe(Subscriber subscriber) {
        subscribersAutoStore.add(subscriber);
    }

    @Override
    public void unsubscribe(Subscriber subscriber) {
        subscribersAutoStore.remove(subscriber);
    }

    @Override
    public void notification(String massage) {
        for (Subscriber subscriber : subscribersAutoStore) {
            subscriber.update("Обновление в автомобильном магазине: " + massage);
        }
    }

    @Override
    public String toString() {
        return String.format("Товар \"%s\" Количество: %s. Цена: %s", name, value, price);
    }
}
