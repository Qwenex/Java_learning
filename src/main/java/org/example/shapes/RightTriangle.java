package org.example.shapes;

/**
 * Фигура прямоугольный треугольник
 */
public class RightTriangle extends Square {

    protected Double a;

    /**
     * @param a Сторона треугольника a
     */
    public RightTriangle(Double a) {
        super(a,"прямоугольный треугольник");
    }

    @Override
    public Double getA() {
        return a;
    }

    @Override
    public void setA(Double a) {
        this.a = a;
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
