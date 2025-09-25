package org.example.entity;

import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Transactional
@Table(name = "solvedEquationList")
public class EquationSolvedEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = EquationEntity.class)
    @JoinColumn(name = "equation_id", nullable = false)
    private EquationEntity equationEntity;

    @OneToOne(cascade = CascadeType.ALL, targetEntity = EquationRootEntity.class)
    @JoinColumn(name= "roots_id")
    private EquationRootEntity equationRootEntity;

    private LocalDateTime createdAt;

    public EquationSolvedEntity() {
    }

    public EquationSolvedEntity(EquationEntity equationEntity, EquationRootEntity equationRootEntity) {
        this.equationEntity = equationEntity;
        this.equationRootEntity = equationRootEntity;
        createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EquationEntity getEquationEntity() {
        return equationEntity;
    }

    public void setEquationEntity(EquationEntity equationEntity) {
        this.equationEntity = equationEntity;
    }

    public EquationRootEntity getEquationRootEntity() {
        return equationRootEntity;
    }

    public void setEquationRootEntity(EquationRootEntity equationRootEntity) {
        this.equationRootEntity = equationRootEntity;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EquationSolvedEntity)) return false;
        EquationSolvedEntity that = (EquationSolvedEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(equationEntity, that.equationEntity) && Objects.equals(equationRootEntity, that.equationRootEntity) && Objects.equals(createdAt, that.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, equationEntity, equationRootEntity, createdAt);
    }

    @Override
    public String toString() {
        return String.format("\nУравнение: %s, Ответ: %s (Id: %s, Создан: %s)", equationEntity, equationRootEntity, id, createdAt);
    }
}

