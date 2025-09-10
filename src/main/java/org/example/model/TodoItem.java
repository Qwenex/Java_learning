package org.example.model;

import java.util.Objects;

public class TodoItem {

    private Integer id;
    private String title;
    private String description;
    private Boolean completed;

    public TodoItem() {
    }

    public TodoItem(Integer id, String title, String description, Boolean completed) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = completed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
        if (!(o instanceof TodoItem)) return false;
        TodoItem todoItem = (TodoItem) o;
        return Objects.equals(id, todoItem.id) && Objects.equals(title, todoItem.title) && Objects.equals(description, todoItem.description) && Objects.equals(completed, todoItem.completed);
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
