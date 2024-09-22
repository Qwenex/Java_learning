package org.example.visitorPattern;

import java.util.Objects;

public class Dot {

    private Double x;
    private Double y;

    public Dot(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    public String getXY() {
        return String.format("(%s : %s)", x, y);
    }

    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }

    public void setXY(Double x, Double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dot)) return false;
        Dot dot = (Dot) o;
        return Objects.equals(x, dot.x) && Objects.equals(y, dot.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%s : %s)", x, y);
    }
}
