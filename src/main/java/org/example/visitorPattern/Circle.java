package org.example.visitorPattern;

import java.util.Objects;

/**
 * Геометрическая фигура: Круг
 */
public class Circle {

    private Dot dotA;
    private Double radius;
    private final RenderVisitor renderVisitor;

    public Circle(Dot dotA, Double radius) {
        this.dotA = dotA;
        this.radius = radius;
        renderVisitor = new RenderVisitor();
    }

    public Dot getDotA() {
        return dotA;
    }

    public void setDotA(Dot dotA) {
        this.dotA = dotA;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        this.radius = radius;
    }

    /**
     * Вычисление периметра круга
     * @return Периметр круга (Double)
     */
    public Double perimeter() {
        return 6.28 * radius;
    }

    /**
     * Вычисление площади круга
     * @return Площадь круга (Double)
     */
    public Double square() {
        return 3.14 * radius * radius;
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
        if (!(o instanceof Circle)) return false;
        Circle circle = (Circle) o;
        return Objects.equals(dotA, circle.dotA) && Objects.equals(radius, circle.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dotA, radius);
    }

    @Override
    public String toString() {
        return String.format("Круг с центром в точке %s и радиусом (%s)", dotA, radius);
    }
}
