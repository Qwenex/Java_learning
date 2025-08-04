package org.example;

import java.util.Objects;

public class User {
    private Integer Id;
    private String name;
    private String last_name;
    private String email;

    public User(Integer id, String name, String last_name, String email) {
        Id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
    }

    public User(Integer id, String email) {
        Id = id;
        this.email = email;
    }

    public Integer getId() {
        return Id;
    }

    public String getName() {
        return name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(Id, user.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, name, last_name, email);
    }

    @Override
    public String toString() {
        return String.format("\nПользователь с Id %s: %s %s. email: %s", getId(), getName(), getLast_name(), getEmail());
    }
}
