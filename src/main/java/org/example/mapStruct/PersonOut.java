package org.example.mapStruct;

import java.time.LocalDate;
import java.util.Objects;

public class PersonOut {

    private String firstName;
    private String secondName;
    private String lastName;
    private LocalDate birthday;

    public PersonOut() {
    }

    public PersonOut(String firstName, String secondName, String lastName, LocalDate birthday) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonOut)) return false;
        PersonOut personOut = (PersonOut) o;
        return Objects.equals(firstName, personOut.firstName) && Objects.equals(secondName, personOut.secondName) && Objects.equals(lastName, personOut.lastName) && Objects.equals(birthday, personOut.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, lastName, birthday);
    }

    @Override
    public String toString() {
        return String.format("\nФИО: %s %s %s. Дата рождения: %s", firstName, secondName, lastName, birthday);
    }
}
