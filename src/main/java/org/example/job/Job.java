package org.example.job;

import org.example.person.Person;
import org.example.document.Document;

/**
 * Абстракный класс работа
 */
public abstract class Job {

    Document document = new Document();
    Person person = new Person();

    public abstract String getJob();

    public String getDocumentHigherEducation() {
        return "";
    }

    public String getDocumentMedicalBook() {
        return "";
    }

    @Override
    public String toString() {
        return String.format("%s, %s. %s %s",person.randomFio(), getJob(), getDocumentHigherEducation(), getDocumentMedicalBook());
    }
}
