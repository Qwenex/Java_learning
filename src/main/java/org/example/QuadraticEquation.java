package org.example;

import io.qameta.allure.Step;

/**
 * Квадратное уравнение
 */
public class QuadraticEquation {

    /**
     * Решение квадратного уравнения ax^2 + bx + c = 0
     * @param a Число a
     * @param b Число b
     * @param c Число c
     * @return Корни уровнения
     */
    @Step(value = "Решение квадратного уравнения")
    public static Root solve(int a, int b, int c) {
        double d = (Math.pow(b, 2) - 4 * a * c);
        double x1 = ((-b + Math.sqrt(d)) / 2 * a);
        double x2 = ((-b - Math.sqrt(d)) / 2 * a);
        if (d < 0) {
            return new Root();
        } else if (d == 0) {
            return new Root(x1);
        } else {
            return new Root(x1, x2);
        }
    }
}

