package org.example.visitorPattern;

import java.util.Objects;

/**
 * Геометрическая фигура: Отрезок (линия)
 */
public class Line {

    private Dot dotA;
    private Dot dotB;
    private final RenderVisitor renderVisitor;

    public Line(Dot dotA, Dot dotB) {
        this.dotA = dotA;
        this.dotB = dotB;
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

    /**
     * Длина отрезка
     * @return Длина отрезка (Double)
     */
    public Double length() {
        // l= sqr((x2-x1)^2 + (y2-y1)^2)
        return Math.sqrt(Math.pow((dotB.getX() - dotA.getX()), 2) + Math.pow((dotB.getY() - dotA.getY()), 2));
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
        if (!(o instanceof Line)) return false;
        Line line = (Line) o;
        return Objects.equals(dotA, line.dotA) && Objects.equals(dotB, line.dotB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dotA, dotB);
    }

    @Override
    public String toString() {
        return String.format("Отрезок соединяющий точки: %s; %s", dotA, dotB);
    }
}