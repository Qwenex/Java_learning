package org.example.shapes;

/**
 * Фигура круг
 */
public class Circle extends Shape {

    protected Double r;

    /**
     * @param r Радиус круга
     */
    public Circle(Double r) {
        super("круг");
        this.r = r;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
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
