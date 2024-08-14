package org.example.shapes;

/**
 * Фигура круг
 */
public class Circle extends Shape {

    public Double r;

    /**
     * @param r Радиус круга
     */
    public Circle(Double r) {
        name = "круг";
        this.r = r;
    }

    /**
     * Нахождение площади фигуры
     * @return площадь фигуры
     */
    @Override
    public Double squareShape() {
        return 3.14 * r * r;
    }
}
