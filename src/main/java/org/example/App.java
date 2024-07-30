package org.example;

import identity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Date;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        Person person = new Person("Лапшин", "Андрей", "02.12.1997");

        person.setSurname("Сергеевич");
        person.setSex("Мужской");
        person.setCitizenship("Россия");
        person.setHeight(178);
        person.setWeight(67);

        logger.info(Person.fullName());
        logger.info(person.getSex());
        logger.info(person.getCitizenship());
        logger.info(person.getHeight() + "");
        logger.info(person.getWeight() + "");


        Date date = new Date();              // Date bai yo
        System.out.println(date);
    }
}
