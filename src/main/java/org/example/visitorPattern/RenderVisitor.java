package org.example.visitorPattern;

public class RenderVisitor {

    public Double renderShape(Line line) {
        return 0.8 * line.length();
    }

    public Double renderShape(Circle circle) {
        return 0.8 * circle.perimeter() + 0.2 * circle.square();
    }

    public Double renderShape(Triangle triangle) {
        return 0.8 * triangle.perimeter() + 0.2 * triangle.square();
    }
}
