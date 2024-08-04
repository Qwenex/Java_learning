package org.example.simpleMath;

public class Calc {

    /**
     * Сложение
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public static double plus(double a, double b){
        return a + b;
    }

    /**
     * Вычетание
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public static double minus(double a, double b){
        return a - b;
    }

    /**
     * Умножение
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public static double multiplication(double a, double b){
        return a * b;
    }

    /**
     * Деление
     * @param a Первое число
     * @param b Второе число
     * @return Ответ
     */
    public static double division(double a, double b){
        return a / b;
    }

    /**
     * Возведение в квадрат
     * @param a Число
     * @return Ответ
     */
    public static double sqr(double a){
        return a * a;
    }

}
