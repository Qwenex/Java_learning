package org.example;

import org.example.address.*;
import org.example.shapes.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        // Задание 1 Shapes
        logger.info("\n\n Задание 1 Фигуры");

        Shape[] shapes = {
                new Square(2.2),
                new Circle(1.7),
                new Rectangle(3.2, 1.7),
                new RightTriangle(3.1),
                new Parallelogram(2.5, 1.9)
        };

        for (int i = 0; i < shapes.length; i++) {
            logger.info("Площадь фигуры {}, равна {}", shapes[i].getName(), shapes[i].squareShape());
        }

        // Задание 2* Address
        logger.info("\n\n Задание 2 Адрес");

        Country[] address = {
                new Street("Russia", "Moscow region", "Moscow", "Lenina st."),
                new Country("Germany"),
                new City("France", "Region Ile-de-France", "Paris"),
                new Region("Russia","Republic of Mordovia"),
                new Street("USA", "District of Columbia", "Washington", "Pl. Jacques Rueff")
        };

        for (int i = 0; i < address.length; i++) {
            logger.info(address[i].getAddress());
        }
    }
}
