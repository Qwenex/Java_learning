package org.example;

import exceptions.DivisionByZero;

/**
 * Простой калькулятор
 */
public class Calc {
    /**
     * Сложение
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public static Double plus(Double a, Double b) {
        return a + b;
    }

    /**
     * Вычетание
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public static Double minus(Double a, Double b) {
        return a - b;
    }

    /**
     * Умножение
     *
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public static Double multiplication(Double a, Double b) {
        return a * b;
    }

    /**
     * Деление
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public static Double division(Double a, Double b) {
        if (b.equals(0.0)) {
            throw new DivisionByZero();
        }
        return a / b;
    }

    /**
     * Возведение в квадрат
     * @param a Число
     * @return Ответ
     */
    public static Double sqr(Double a) {
        return a * a;
    }
}
