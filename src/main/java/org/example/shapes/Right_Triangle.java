package org.example.shapes;

public class Right_Triangle extends Square{

    @Override
    public double squareShape(double a) {
        return super.squareShape(a)/2;
    }
}
