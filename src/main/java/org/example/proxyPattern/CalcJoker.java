package org.example.proxyPattern;

import java.util.Random;

/**
 * Простой "не точный" калькулятор
 */
public class CalcJoker implements CalcInterface {
    Random rnd = new Random();

    @Override
    public Double plus(Double a, Double b) {
        return a + b + rnd.nextDouble() - rnd.nextDouble();
    }

    @Override
    public Double minus(Double a, Double b) {
        return a - b + rnd.nextDouble() - rnd.nextDouble();
    }

    @Override
    public Double multiplication(Double a, Double b) {
        return a * b + rnd.nextDouble() - rnd.nextDouble();
    }

    @Override
    public Double division(Double a, Double b) {
        return a / b + rnd.nextDouble() - rnd.nextDouble();
    }
}
