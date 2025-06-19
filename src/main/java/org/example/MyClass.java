package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.function.Predicate;

public class MyClass {

    public static Logger logger = LoggerFactory.getLogger(MyClass.class);

    /**
     * Проверка на четность числа
     * @param value       Число
     * @param myPredicate Функциональный интерфейс (By user)
     */
    public static void isEven(Integer value, MyPredicate myPredicate) {
        logger.info(myPredicate.test(value).toString());
    }

    /**
     * Проверка на четность числа
     * @param value     Число
     * @param predicate Функциональный интерфейс (Default)
     */
    public static void isEven2(Integer value, Predicate<Integer> predicate) {
        logger.info(String.valueOf(predicate.test(value)));
    }
}
