package org.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rootList")
public class EquationRootEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double x1;
    private Double x2;

    public EquationRootEntity(){
    }

    public EquationRootEntity(Double x1){
        this.x1 = x1;
    }

    public EquationRootEntity(Double x1, Double x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquationRootEntity)) return false;
        EquationRootEntity equationRootEntity = (EquationRootEntity) o;
        return Objects.equals(x1, equationRootEntity.x1) && Objects.equals(x2, equationRootEntity.x2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x1, x2);
    }

    @Override
    public String toString() {
        if (x1 != null && x2 != null) {
            return String.format("x₁=%.2f | x₂=%.2f", x1, x2);
        } else if (x1 != null) {
            return String.format("Один корень: x=%.2f", x1);
        } else {
            return "Корней нет";
        }
    }

}
