package org.example;

/**
 * Умнейший, но все еще простейший калькулятор
 */
public class CalcGeneric {

    /**
     * Сложение
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public static <T extends Number> Double plus(T a, T b) {
        return a.doubleValue() + b.doubleValue();
    }

    /**
     * Вычетание
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public static <T extends Number> Double minus(T a, T b) {
        return (double) Math.round((a.doubleValue() - b.doubleValue()) * 1000) / 1000;
    }

    /**
     * Умножение
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public static <T extends Number> Double multiplication(T a, T b) {
        return a.doubleValue() * b.doubleValue();
    }

    /**
     * Деление
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public static <T extends Number> Double division(T a, T b) {
        if (b.equals(0) || b.equals(0.0)) {
            throw new ArithmeticException("Деление на ноль не поддерживается");
        }
        return (double) Math.round((a.doubleValue() / b.doubleValue()) * 1000) / 1000;
    }
}