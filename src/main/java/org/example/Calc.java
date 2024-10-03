package org.example;

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
        return (double) Math.round((a - b) * 1000) / 1000;
    }

    /**
     * Умножение
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
        if (b == 0.0) {
            throw new ArithmeticException("Деление на ноль не поддерживается");
        }
        return (double) Math.round(a / b * 1000) / 1000;
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