package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        logger.info("\n Задание 1. Калькулятор Generic");
        logger.info(CalcGeneric.plus(26, 4.5).toString());
        logger.info(CalcGeneric.minus(26.5, 4.5).toString());
        logger.info(CalcGeneric.multiplication(26, 4.5).toString());
        logger.info(CalcGeneric.division(26, 4.5).toString());

        logger.info("\n Задание 2. Запись и чтение массива Generic");
        ArrayList<Object> list = new ArrayList<>();
        ArrayInformer.writeArray(list, 12);
        ArrayInformer.writeArray(list, 12.5);
        ArrayInformer.writeArray(list, "Hello");
        ArrayInformer.rewriteIndexArray(list, 1, 12.7);
        ArrayInformer.readArray(list);
        ArrayInformer.readIndexArray(list, 0);
    }
}