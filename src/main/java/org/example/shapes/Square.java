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
        super("квадрат");
        this.a = a;
    }

    protected Square(Double a, String name) {
        super(name);
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
