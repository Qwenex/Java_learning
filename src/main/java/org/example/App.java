package org.example;

import org.example.bridgePattern.Car;
import org.example.bridgePattern.Vehicle;
import org.example.decoratorPattern.CookedVegetables;
import org.example.decoratorPattern.WashedVegetables;
import org.example.visitorPattern.Circle;
import org.example.visitorPattern.Dot;
import org.example.visitorPattern.Line;
import org.example.visitorPattern.Triangle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class App {
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        // Задание 1. Паттерн Visitor
        logger.info("\n\n Задание 1. Visitor");
        Line line = new Line(new Dot(3.8, 1.5), new Dot(2.6, 5.1));
        Circle circle = new Circle(new Dot(5.1, 5.3), 2.6);
        Triangle triangle = new Triangle(new Dot(4.2, 3.1), new Dot(6.2, 6.9), new Dot(1.3, 8.6));

        logger.info(String.format("Геометрическая фигура {%s} Длина равна: %.2f; Кол-во точек для рендеринга: %.2f.",
                line, line.length(), line.renderShape()));
        logger.info(String.format("Геометрическая фигура {%s} Периметр равен: %.2f; Площадь равна: %.2f; Кол-во точек для рендеринга: %.2f.",
                circle, circle.perimeter(), circle.square(), circle.renderShape()));
        logger.info(String.format("Геометрическая фигура {%s} Периметр равен: %.2f; Площадь равна: %.2f; Кол-во точек для рендеринга: %.2f.",
                triangle, triangle.perimeter(), triangle.square(), triangle.renderShape()));

        // Задание 2. Паттерн Decorator
        logger.info("\n\n Задание 2. Decorator");
        WashedVegetables Vegetables = new CookedVegetables();
        logger.info(Vegetables.cook());

        // Задание 3. Паттерн Bridge
        logger.info("\n\n Задание 3. Bridge");
        Vehicle car = new Car();
        List<String> carLife = new ArrayList<>();
        carLife.add("\n" + car.engineStatus());
        carLife.add("\n" + car.engineOn());
        carLife.add("\n" + car.engineStatus());
        carLife.add("\n" + car.engineOff());
        carLife.add("\n" + car.engineSwitch());
        carLife.add("\n" + car.drive());
        carLife.add("\n" + car.refuel(20));
        carLife.add("\n" + car.parking());
        carLife.add("\n" + car.engineStatus());

        logger.info(carLife.toString());
    }
}