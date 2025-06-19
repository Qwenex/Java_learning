package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class App {

    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("\n Задание 1 Лямбда функция проверки четности числа");

        // Способ 1: функциональный интерфейс напрямую
        MyPredicate myPredicate = x -> x % 2 == 0;
        logger.info(myPredicate.test(10).toString());

        //Способ 2: Отдельный класс
        MyClass.isEven(11, x -> x % 2 == 0);

        //Способ 3: Default функциональный интерфейс напрямую
        Predicate<Integer> predicate = x -> x % 2 == 0;
        logger.info(String.valueOf(predicate.test(12)));

        // Способ 4: Отдельный класс и default функциональный интерфейс
        MyClass.isEven2(13, x -> x % 2 == 0);

        logger.info("\n Задание 2 Поиск по массиву с помощью Steam API");

        ArrayList<Country> countries = new ArrayList<>();
        countries.add(new Country("Россия", 17100000, 143000000));
        countries.add(new Country("Германия", 357592, 83000000));
        countries.add(new Country("Франция", 551695, 68290000));
        countries.add(new Country("Индия", 3287000, 1432000000));
        countries.add(new Country("Швейцария", 41285, 8888000));
        countries.add(new Country("США", 9833517, 340000000));
        countries.add(new Country("Канада", 9985000, 40100000));
        countries.add(new Country("Чехия", 78871, 10860000));
        countries.add(new Country("Румыния", 238397, 19060000));
        countries.add(new Country("Казахстан", 2725000, 20330000));
        countries.add(new Country("Китай", 9597000, 1411000000));
        countries.add(new Country("Люксенбург", 2586, 666430));
        countries.add(new Country("Польша", 322575, 36690000));

        logger.info("Исходная коллекция:{}", countries);

        /*
        Сортировка по:
        1) Численность населения больше 40млн чел
        2) Отсортировать по плотности населения от большего числа
        3) Страны в названии имеют букву "а"
        4) Получить массив названий стран
         */
        List<String> countriesSort =
        countries.stream()
                .filter(country -> country.getPopulation() > 40000000)
                .sorted(Comparator.comparing(Country::getDensity).reversed())
                .map(Country::getName)
                .filter(name -> name.toLowerCase().contains("а"))
                .collect(Collectors.toList());

        logger.info("Отсортированный массив:\n{}", countriesSort);

    }
}