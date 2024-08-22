package org.example.job;

import org.example.document.Document;
import org.example.document.HigherEducation;

/**
 * Класс профессии иженер
 */
public class Engineer extends Job implements HigherEducation {

    private final Document higherEducationDocument;

    public Engineer(Document higherEducationDocument) {
        this.higherEducationDocument = higherEducationDocument;
    }

    @Override
    public Document getDocumentHigherEducation() {
        return higherEducationDocument;
    }

    @Override
    public String getNameJob() {
        return "Инженер";
    }

    @Override
    public String toString() {
        return String.format("%s. Документы: {%s}",super.toString(), higherEducationDocument);
    }
}