package org.example.serializationTest;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class User implements Serializable {
    private static final long serialVersionUID = 2L;

    private Integer id;
    private String login;
    private transient String password;
    private LocalDate creationDate;
    private Boolean vipStatus;

    public User(Integer id, String login, String password, LocalDate creationDate, Boolean vipStatus) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.creationDate = creationDate;
        this.vipStatus = vipStatus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public Boolean getVipStatus() {
        return vipStatus;
    }

    public void setVipStatus(Boolean vipStatus) {
        this.vipStatus = vipStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id)
                && Objects.equals(login, user.login)
                && Objects.equals(password, user.password)
                && Objects.equals(creationDate, user.creationDate)
                && Objects.equals(vipStatus, user.vipStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, login, password, creationDate, vipStatus);
    }

    @Override
    public String toString() {
        return String.format("\nID: %s. Логин: %s. Пароль:%s. Дата создания: %s.", id, login, password, creationDate);
    }
}
