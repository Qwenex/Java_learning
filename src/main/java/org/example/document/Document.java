package org.example.document;

import java.time.LocalDate;

public class Document {

    private final String name;
    private final String number;
    private final String serial;
    private final LocalDate date;

    public Document(String name, String number, String serial, LocalDate date) {
        this.name = name;
        this.number = number;
        this.serial = serial;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getSerial() {
        return serial;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {
        return String.format("%s. Номер: %s, Серия: %s, Дата: %s", name, number, serial, date);
    }
}