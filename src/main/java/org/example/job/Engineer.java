package org.example.job;

import org.example.document.HigherEducation;

/**
 * Класс профессии иженер
 */
public class Engineer extends Job implements HigherEducation {

    @Override
    public String getDocumentHigherEducation() {
        return document.getDocumentHigherEducation();
    }

    @Override
    public String getJob() {
        return "работает инженером";
    }
}
