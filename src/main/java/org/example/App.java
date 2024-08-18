package org.example;

import org.example.address.Country;
import org.example.address.City;
import org.example.address.Region;
import org.example.address.Street;
import org.example.shapes.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        // Задание 1 Shapes

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

        Country address = new Street();
        City city = new City();
        logger.info(city.getCityFrance());
        logger.info(address.addressRussia());
        logger.info(address.addressUsa());
        logger.info(address.addressFrance());

    }
}
