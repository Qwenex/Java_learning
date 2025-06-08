package org.example.shapes;

/**
 * Фигура параллелограмм
 */
public class Parallelogram extends Square {

    protected Double h;

    /**
     * @param a Сторона параллелограмма a
     * @param h Высота параллелограмма h
     */
    public Parallelogram(Double a, Double h) {
        super(a, "параллелограмм");
        this.h = h;
    }

    public Double getH() {
        return h;
    }

    public void setH(Double h) {
        this.h = h;
    }

    /**
     * Нахождение площади фигуры
     *
     * @return площадь фигуры
     */
    @Override
    public Double squareShape() {
        return a * h;
    }
}
