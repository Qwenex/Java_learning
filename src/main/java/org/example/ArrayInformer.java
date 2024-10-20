package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Статические методы работы с массивами (с логированием), при помощи Generic wildcard
 */
public class ArrayInformer {

    public static Logger logger = LoggerFactory.getLogger(ArrayInformer.class);

    /**
     * Добавление элемента в массив
     * @param array Массив
     * @param value Элемент массива
     * @param <T>   Тип
     */
    public static <T> void writeArray(List<? super T> array, T value) {
        logger.info("Элемент \"{}\" был добавлен в массив, состоящий из элементов: {}", value, array);
        array.add(value);
    }

    /**
     * Добавление элемента в массив на заданный индекс
     * @param array Массив
     * @param index Индекс в массиве
     * @param value Элемент массива
     * @param <T>   Тип
     */
    public static <T> void writeIndexArray(List<? super T> array, int index, T value) {
        logger.info("На индекс \"{}\", был записан элемент \"{}\"", index, value);
        array.add(index, value);
    }

    /**
     * Изменение элемента в массиве по заданному индексу
     * @param array Массив
     * @param index Индекс в массиве
     * @param value Элемент массива
     * @param <T>   Тип
     */
    public static <T> void rewriteIndexArray(List<? super T> array, int index, T value) {
        logger.info("На индекс \"{}\", который занимал элемент \"{}\", был перезаписан элемент \"{}\"",
                index, array.get(index), value);
        array.remove(index);
        array.add(index, value);
    }

    /**
     * Получение элементов массива
     * @param array Массив
     * @param <T>   Тип
     */
    public static <T> void readArray(List<? extends T> array) {
        logger.info("Массив состоит из {} элементов: {}", array.size(), array);
    }

    /**
     * Получение элемента массива по индексу
     * @param array Массив
     * @param <T>   Тип
     */
    public static <T> void readIndexArray(List<? extends T> array, int index) {
        logger.info("Индекс \"{}\" занимает элемент \"{}\"", index, array.get(index));
    }
}
