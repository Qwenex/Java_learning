package org.example.shapes;

/**
 * Родительский класс геометрических фигур.
 */
public class Shape {

    private final String name;

    public Shape(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     * Нахождение площади фигуры
     * @return площадь фигуры
     */
    public Double squareShape() {
        return 0.0;
    }
}
