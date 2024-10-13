package org.example;

import java.util.Objects;

public class Root {
    private Double x1;
    private Double x2;

    public Root(Double x1, Double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public Root(Double x1) {
        this.x1 = x1;
    }

    public Root() {
    }

    public Double getX1() {
        return x1;
    }

    public Double getX2() {
        return x2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Root)) return false;
        Root root = (Root) o;
        return (Objects.equals(x1, root.x1) && Objects.equals(x2, root.x2))
                || (Objects.equals(x1, root.x2) && Objects.equals(x2, root.x1));
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2);
    }

    @Override
    public String toString() {
        if (x1 != null && x2 != null) {
            return String.format("Корни уравнения: %s, %s", x1, x2);
        } else if (x1 != null) {
            return String.format("Один корень уравнения: %s", x1);
        } else {
            return String.format("Корней уравнения нет");
        }
    }
}
