package org.example.mappingTest;

import java.util.Objects;

public class PersonIn {
    private String fio;
    private Integer age;

    public PersonIn(){
    }

    public PersonIn(String fio, Integer age) {
        this.fio = fio;
        this.age = age;
    }

    public String getName() {
        return fio;
    }

    public void setName(String name) {
        this.fio = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonIn)) return false;
        PersonIn personIn = (PersonIn) o;
        return Objects.equals(fio, personIn.fio) && Objects.equals(age, personIn.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fio, age);
    }

    @Override
    public String toString() {
        return String.format("\nФИО: %s. Возраст: %s", fio, age );
    }

}
