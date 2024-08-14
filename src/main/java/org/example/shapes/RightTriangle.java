package org.example.shapes;

/**
 * Фигура прямоугольный треугольник
 */
public class RightTriangle extends Square {

    public Double a;

    /**
     * @param a Сторона треугольника a
     */
    public RightTriangle(Double a) {
        super(a);
        name = "прямоугольный треугольник";
    }

    /**
     * Нахождение площади фигуры
     * @return площадь фигуры
     */
    @Override
    public Double squareShape() {
        return super.squareShape() / 2;
    }
}
