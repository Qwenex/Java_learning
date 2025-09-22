package org.example.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "todos")
public class TodoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(length = 500)
    private String description;

    @Column(nullable = false)
    private Boolean completed = false;

    public TodoEntity() {
    }

    public TodoEntity(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getCompleted() {
        return completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TodoEntity)) return false;
        TodoEntity todoEntity = (TodoEntity) o;
        return Objects.equals(id, todoEntity.id)
                && Objects.equals(title, todoEntity.title)
                && Objects.equals(description, todoEntity.description)
                && Objects.equals(completed, todoEntity.completed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, completed);
    }

    @Override
    public String toString() {
        String status = this.completed ? "Выполнено" : "Не выполнено";
        return String.format("\n[Задача номер %s] \nНазвание: %s \nОписание: %s \nСтатус: %s", id, title, description, status);
    }
}
