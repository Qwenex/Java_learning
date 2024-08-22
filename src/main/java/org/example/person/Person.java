package org.example.person;

import org.example.job.Job;

/**
 * Класс персона с полями ФИО, Возраст, Работа
 */
public class Person {

    private final String fio;
    private final Integer age;
    private final Job job;

    public Person(String fio, Integer age, Job job) {
        this.fio = fio;
        this.age = age;
        this.job = job;
    }

    public String getFio() {
        return fio;
    }

    public Integer getAge() {
        return age;
    }

    public Job getJob() {
        return job;
    }

    @Override
    public String toString() {
        return String.format("ФИО: %s, Возраст: %s, Должность: %s", getFio(), getAge(), getJob().toString());

    }
}