package org.example.proxyPattern;

/**
 * Простой калькулятор
 */
public class Calc implements CalcInterface {
    /**
     * Сложение
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public Double plus(Double a, Double b) {
        return a + b;
    }

    /**
     * Вычетание
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public Double minus(Double a, Double b) {
        return a - b;
    }

    /**
     * Умножение
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public Double multiplication(Double a, Double b) {
        return a * b;
    }

    /**
     * Деление
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public Double division(Double a, Double b) {
        return a / b;
    }
}