package org.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "equationList")
public class EquationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double a;
    private Double b;
    private Double c;

    public EquationEntity() {
    }

    public EquationEntity(Double a, Double b, Double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Double getA() {
        return a;
    }

    public void setA(Double a) {
        this.a = a;
    }

    public Double getB() {
        return b;
    }

    public void setB(Double b) {
        this.b = b;
    }

    public Double getC() {
        return c;
    }

    public void setC(Double c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquationEntity)) return false;
        EquationEntity equationEntity = (EquationEntity) o;
        return Objects.equals(a, equationEntity.a)
                && Objects.equals(b, equationEntity.b)
                && Objects.equals(c, equationEntity.c);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c);
    }

    @Override
    public String toString() {
        return String.format("Уравнение: %s(x^2)%sx%s=0",
                a, b >= 0 ? "+" + b : b, c >= 0 ? "+" + c : c);
    }
}
