package org.example.shapes;

/**
 * Фигура параллелограмм
 */
public class Parallelogram extends Square {

    public Double h;

    /**
     * @param a Сторона параллелограмма a
     * @param h Высота параллелограмма h
     */
    public Parallelogram(Double a, Double h) {
        super(a);
        name = "параллелограмм";
        this.h = h;
    }

    /**
     * Нахождение площади фигуры
     * @return площадь фигуры
     */
    @Override
    public Double squareShape() {
        return super.squareShape();
    }
}
