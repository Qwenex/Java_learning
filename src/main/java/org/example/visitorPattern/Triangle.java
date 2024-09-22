package org.example.visitorPattern;

import java.util.Objects;

/**
 * Геометрическая фигура: Треугольник
 */
public class Triangle {

    private Dot dotA;
    private Dot dotB;
    private Dot dotC;
    private final RenderVisitor renderVisitor;

    public Triangle(Dot dotA, Dot dotB, Dot dotC) {
        this.dotA = dotA;
        this.dotB = dotB;
        this.dotC = dotC;
        renderVisitor = new RenderVisitor();
    }

    public Dot getDotA() {
        return dotA;
    }

    public void setDotA(Dot dotA) {
        this.dotA = dotA;
    }

    public Dot getDotB() {
        return dotB;
    }

    public void setDotB(Dot dotB) {
        this.dotB = dotB;
    }

    public Dot getDotC() {
        return dotC;
    }

    public void setDotC(Dot dotC) {
        this.dotC = dotC;
    }

    /**
     * Вычисление периметра треугольника
     * @return Периметр треугольника (Double)
     */
    public Double perimeter() {
        // l = sqr((x2-x1)^2 + (y2-y1)^2)
        Double a = Math.sqrt(Math.pow((dotC.getX() - dotB.getX()), 2) + Math.pow((dotC.getY() - dotB.getY()), 2)); // BC
        Double b = Math.sqrt(Math.pow((dotC.getX() - dotA.getX()), 2) + Math.pow((dotC.getY() - dotA.getY()), 2)); // AC
        Double c = Math.sqrt(Math.pow((dotB.getX() - dotA.getX()), 2) + Math.pow((dotB.getY() - dotA.getY()), 2)); // AB
        return a + b + c;
    }

    /**
     * Вычисление площади треугольника
     * @return Площадь треугольника (Double)
     */
    public Double square() {
        // S= 1/2*|(x2-x1)(y3-y1)-(x3-x1)(y2-y1)|
        return 0.5 * Math.abs(
                (dotB.getX() - dotA.getX()) * (dotC.getY() - dotA.getY())
                        - (dotC.getX() - dotA.getX()) * (dotB.getY()) - dotA.getY());
    }

    /**
     * Рендеринг фигуры
     * @return Рендер фигуры: Кол-во точек (Double)
     */
    public Double renderShape() {
        return renderVisitor.renderShape(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Triangle)) return false;
        Triangle triangle = (Triangle) o;
        return Objects.equals(dotA, triangle.dotA) && Objects.equals(dotB, triangle.dotB) && Objects.equals(dotC, triangle.dotC);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dotA, dotB, dotC);
    }

    @Override
    public String toString() {
        return String.format("Треугольник с вершинам в точках: %s; %s; %s", dotA, dotB, dotC);
    }
}
