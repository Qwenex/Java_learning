package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDate;

public class App
{
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        Person firstPerson = new Person("Петров Иван Сидорович", LocalDate.of(2007,12,31),"Москва");
        Person secondPerson = new Person("петРоВ ИВАН СидоровиЧ", LocalDate.of(2007,12,31),"МОСКВА");
        firstPerson.setPhoneNumber("8 800 555 35 35");
        firstPerson.setHairColor("Серобуромалиновый");

        /* Задание 1 и 2*. Сравнение ФИО, даты рождения и города рождения без учета регистра.
        Написание к этим значениям HashCode с и без использования Objects.hash
        */
        logger.info(String.valueOf(firstPerson));
        logger.info("Номер телефона: {}", firstPerson.getPhoneNumber());
        logger.info("Цвет волос: {}", firstPerson.getHairColor());
        logger.info(String.valueOf(firstPerson.equals(secondPerson)));
        logger.info(String.valueOf(firstPerson.hashCode()));
        logger.info(String.valueOf(secondPerson.hashCode()));
    }
}