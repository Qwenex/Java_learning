package org.example.shapes;

/**
 * Фигура прямоугольник
 */
public class Rectangle extends Square {

    protected Double b;

    /**
     * @param a Сторона прямоугольника a
     * @param b Сторона прямоугольника b
     */
    public Rectangle(Double a, Double b) {
        super(a,"прямоугольник");
        this.b = b;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    /**
     * Нахождение площади фигуры
     * @return площадь фигуры
     */
    @Override
    public Double squareShape() {
        return a * b;
    }
}
