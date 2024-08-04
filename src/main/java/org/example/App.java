package org.example;

import org.example.identity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.example.simpleMath.Calc;
import java.time.LocalDate;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        Person person = new Person("Лапшин", "Андрей", LocalDate.of(1997, 12, 2));
        person.setSurname("Сергеевич");
        person.setSex("Мужской");
        person.setCitizenship("Россия");
        person.setHeight(178);
        person.setWeight(67);

        logger.info("ФИО: {}", person.fullName());
        logger.info("Дата рождения: {}", person.getBirthDay().toString());
        logger.info("Пол: {}", person.getSex());
        logger.info("Гражданство: {}", person.getCitizenship());
        logger.info("Рост: {} См", person.getHeight().toString());
        logger.info("Вес: {} Кг", person.getWeight().toString());
        logger.info("Возраст: {} Лет", person.getAge());
        logger.info("Совершеннолетие: {}", person.isAdult());
        logger.info(String.valueOf(Calc.plus(5.3, 2.5)));
        logger.info(String.valueOf(Calc.minus(5.3, 2.5)));
        logger.info(String.valueOf(Calc.multiplication(5.3, 2.5)));
        logger.info(String.valueOf(Calc.division(5.3, 2.5)));
        logger.info(String.valueOf(Calc.sqr(5.3)));
    }
}