package org.example;

import exceptions.DivisionByZero;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utils.RandomGenerate;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        // Задание 1 Калькулятор, ошибка при делении на ноль
        try {
            logger.info(String.valueOf(Calc.division(5.0, 0.0)));
        } catch (DivisionByZero e) {
            logger.error("Деление на ноль невозможно");
        }

        logger.info("");

        // Задание 2* Person. Запись в файл
        // l - Количество персон (строк) которые записываются в файл и считываются из файла
        int l = 10;
        try (FileWriter fileWriter = new FileWriter("persons.txt")) {
            for (int i = 0; i < l; i++) {
                fileWriter.write(String.format("%s %s \n", RandomGenerate.randomFio(), RandomGenerate.randomAge()));
            }
        } catch (IOException e) {
            logger.error("Ошибка записи файла {}", e.getMessage());
        }

        /* Задание 2* считывание файла и запись в массив.
        Так как, при вызове простого массива, невозможно изменить его размер в последствии,
        необходимо знать кол-во строк в файле.  */
        try (FileReader fileReader = new FileReader("persons.txt")) {
            Scanner scan = new Scanner(fileReader);
            String[] persons = new String[l];
            for (int i = 0; i < persons.length; i++) {
                persons[i] = scan.nextLine();
                logger.info(persons[i]);
            }
        } catch (IOException e) {
            logger.error("Ошибка чтения файла при записи в массив {}", e.getMessage());
        }

        logger.info("");

        // Задание 2* считывание файла и запись в консоль
        try (FileReader fileReader = new FileReader("persons.txt")) {
            Scanner scan = new Scanner(fileReader);
            while (scan.hasNextLine()) {
                logger.info(scan.nextLine());
            }
        } catch (IOException e) {
            logger.error("Ошибка чтения файла при записи в консоль {}", e.getMessage());
        }
    }
}