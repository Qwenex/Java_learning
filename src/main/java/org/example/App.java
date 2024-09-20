package org.example;

import org.example.facadePattern.SimpleSoup;
import org.example.observerPattern.publishers.AutoStore;
import org.example.observerPattern.publishers.ElectronicStore;
import org.example.observerPattern.publishers.HardwareStore;
import org.example.observerPattern.subscribers.EmailSubscriber;
import org.example.observerPattern.subscribers.PhoneSmsSubscriber;
import org.example.proxyPattern.Calc;
import org.example.proxyPattern.CalcInterface;
import org.example.proxyPattern.CalcJoker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        // Задание 1. Паттерн Proxy
        logger.info("\n\n Задание 1. Паттерн Proxy");

        CalcInterface calc = new Calc();
        LocalDate date = LocalDate.now();
        date = LocalDate.of(2024, 4, 1); // Симуляция 1-го апреля, вместо текущей даты
        if (date.getMonthValue() == 4 && date.getDayOfMonth() == 1) {
            calc = new CalcJoker();
        }

        logger.info(calc.plus(9.0, 3.0).toString());
        logger.info(calc.minus(9.0, 3.0).toString());
        logger.info(calc.multiplication(9.0, 3.0).toString());
        logger.info(calc.division(9.0, 3.0).toString());

        // Задание 2. Паттерн Observer
        logger.info("\n\n Задание 2. Паттерн Observer");

        EmailSubscriber emailSubscriber = new EmailSubscriber();
        PhoneSmsSubscriber phoneSmsSubscriber = new PhoneSmsSubscriber();

        ElectronicStore elcStoreKettle = new ElectronicStore("Чайник Phillips T1000", 15, 3250);
        ElectronicStore elcStoreSmartphone = new ElectronicStore("Смартфон Google pixel 7 pro", 10, 38600);
        HardwareStore hWStoreShovel = new HardwareStore("Лопата строительная", 10, 300);
        AutoStore autoStoreNiva = new AutoStore("Нива Legend", 3, 920000);

        elcStoreKettle.subscribe(phoneSmsSubscriber);
        elcStoreSmartphone.subscribe(phoneSmsSubscriber);
        hWStoreShovel.subscribe(emailSubscriber);
        autoStoreNiva.subscribe(emailSubscriber);

        elcStoreKettle.setValue(30);
        elcStoreKettle.setPrice(3500);
        elcStoreSmartphone.setPrice(37250);
        hWStoreShovel.setPrice(360);
        autoStoreNiva.setValue(5);
        autoStoreNiva.unsubscribe(emailSubscriber);
        autoStoreNiva.setPrice(958000);

        // Задание 3. Паттерн Facade
        logger.info("\n\n Задание 3. Паттерн Facade");

        SimpleSoup simpleSoup = new SimpleSoup();
        logger.info(simpleSoup.cookSimpleSoup());
        logger.info(simpleSoup.cookSimplePastaSoup());
    }
}