package org.example;

import org.example.shapes.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App
{
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        Shape square = new Square();
        Shape circle = new Circle();
        Shape rectangle = new Rectangle();
        Shape rightTriangle = new Right_Triangle();
        Shape parallelogram = new Parallelogram();

        logger.info("Площадь квадрата " + (square.squareShape(2)));
        logger.info("Площадь круга " + (circle.squareShape(2)));
        logger.info("Площадь прямоугольника " + (rectangle.squareShape(2,3)));
        logger.info("Площадь прямоугольного треугольника " + (rightTriangle.squareShape(2)));
        logger.info("Площадь параллелограмма " + (parallelogram.squareShape(2,3)));
    }
}
