package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    /**
     * Задание 1. Удаление элемента их массива
     * @param list  Исходный массив
     * @param index Удаляемый индекс
     * @return Массив с удаленным индексом
     */
    public static ArrayList<Integer> deleteIndexList(ArrayList<Integer> list, int index) {
        list.remove(index);
        return list;
    }

    /**
     * Задание 2. Удаление дубликатов из коллекции
     * @param collection Исходная коллекция
     * @return Коллекция без дубликатов
     */
    public static HashSet<Integer> deleteIndexDuplicate(Collection<Integer> collection) {
        return new HashSet<>(collection);
    }

    /**
     * Задание 4. Цвет RGB с использованием switch-case
     * @param index Индекс цвета
     * @return Яркость, цвет и RGB выбранного цвета
     */
    public static String getColor(Integer index) {
        String bright;
        if (index > Color.values().length || index < 0) {
            return "Заданного индекска цвета не существует";
        }
        switch (Color.values()[index]) {
            case WHITE:
            case RED:
            case GREEN:
            case BLUE:
            case AQUA:
            case YELLOW:
            case ORANGE:
            case PINK:
                bright = "Яркий цвет";
                break;
            case BLACK:
            case GOLD:
            case SILVER:
            case BRONZE:
            case NAVY:
            case MAROON:
                bright = "Тусклый цвет";
                break;
            default:
                bright = "Неизвестный цвет";
        }
        return String.format("%s: %s (rgb: %s)", bright, Color.values()[index], Color.values()[index].getRGB());
    }

    /**
     * Задание 5* Поменять в hashMap ключи и значения местами
     * @param map Исходный hashMap
     * @return Измененный hashMap в котором поменяны ключи и их значения местами
     */
    public static HashMap<Integer, String> reversHashMap(HashMap<String, Integer> map) {
        HashMap<Integer, String> reverseMap = new LinkedHashMap<>();
        for (String i : map.keySet()) {
            reverseMap.put(map.get(i), i);
        }
        return reverseMap;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 6, 7, 1));

        HashMap<String, Integer> map = new LinkedHashMap<>();
        map.put("Андрей", 20);
        map.put("Сергей", 30);
        map.put("Инокентий", 40);
        map.put("Елизавета", 18);

        logger.info("Задание 1");
        logger.info((deleteIndexList(list, 3) + "\n"));

        logger.info("Задание 2");
        logger.info((deleteIndexDuplicate(list)) + "\n");

        logger.info("Задание 3");
        logger.info(map + "\n");

        logger.info("Задание 4");
        logger.info(Arrays.toString(Color.values()));
        logger.info(getColor(8) + "\n");

        logger.info("Задание 5*");
        logger.info(String.valueOf(reversHashMap(map)));
    }
}