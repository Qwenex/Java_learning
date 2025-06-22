package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        // Задание 1. Проверка правильности написания логина (Емайла)
        logger.info("\nЗадание 1. Список логинов:");

        List<String> emails = new ArrayList<>();
        emails.add("Werewolf98123@yandex.ru");
        emails.add("nomadTr_28@gmail.com");
        emails.add("74Meh0No1d@yahoo.com");
        emails.add("Oracl@872.ger");
        emails.add("873245878gmail.com");
        emails.add("Admin72138@gool.ruru");
        emails.add("_The768jsd@jsad.com");
        emails.add("Hmegtsd_23@sdoposd");
        emails.add("TheElephant@mail.ru");
        emails.add("Tester293@ys.sd");
        emails.add("Hm_nys234@dasd.sd2");

        for (String emailStr : emails) {
            logger.info(emailStr);
        }

        String regexEmail = "^[A-Za-z]\\w+@[a-z]{3,6}\\.[a-z]{2,3}$";
        Pattern patternCompileEmails = Pattern.compile(regexEmail);

        for (String emailStr : emails) {
            Matcher matcherEmails = patternCompileEmails.matcher(emailStr);
            if (matcherEmails.matches()) {
                logger.info(matcherEmails.toString());
            }
        }

        // Задание 2. Проверка правильности русских автомобильных номеров
        logger.info("\nЗадание 2. Автомобильные номера:");

        List<String> plates = new ArrayList<>();
        plates.add("А001АА13RUS");
        plates.add("К285СК99rus");
        plates.add("В231УХ15RUS");
        plates.add("Ч002НЕ22RUS");
        plates.add("А3415А92RUS");
        plates.add("К387РС124RUS");
        plates.add("О989СТ724RUS");
        plates.add("К387РС024RUS");
        plates.add("В000КН19RUS");
        plates.add("М001АА01RUS");

        for (String platesStr : plates) {
            logger.info(platesStr);
        }

        String regexPlate = "^[АВЕКМНОРСТУХ]((?!000)\\d{3})[АВЕКМНОРСТУХ]{2}([1-9]?\\d{2})RUS$";
        Pattern patternCompilePlates = Pattern.compile(regexPlate);

        for (String platesStr : plates) {
            Matcher matcherPlates = patternCompilePlates.matcher(platesStr);
            if (matcherPlates.matches()) {
                logger.info(matcherPlates.toString());
            }
        }


    }
}