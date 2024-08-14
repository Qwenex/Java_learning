package org.example.shapes;

/**
 * Фигура квадрат
 */
public class Square extends Shape {

    public Double a;

    /**
     * @param a Сторона квадрата a
     */
    public Square(Double a) {
        name = "квадрат";
        this.a = a;
    }

    /**
     * Нахождение площади фигуры
     * @return площадь фигуры
     */
    @Override
    public Double squareShape() {
        return a * a;
    }
}
