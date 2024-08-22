package org.example.job;

import org.example.document.Document;
import org.example.document.HigherEducation;
import org.example.document.MedicalBook;

/**
 * Класс профессии доктор
 */
public class Doctor extends Job implements HigherEducation, MedicalBook {

    private final Document higherEducationDocument;
    private final Document medicalBookDocument;

    public Doctor(Document higherEducationDocument, Document medicalBookDocument) {
        this.higherEducationDocument = higherEducationDocument;
        this.medicalBookDocument = medicalBookDocument;
    }

    @Override
    public Document getDocumentHigherEducation() {
        return higherEducationDocument;
    }

    @Override
    public Document getDocumentMedicalBook() {
        return medicalBookDocument;
    }

    @Override
    public String getNameJob() {
        return "Доктор";
    }

    @Override
    public String toString() {
        return String.format("%s. Документы: {%s}, {%s}",super.toString(), higherEducationDocument, medicalBookDocument);
    }
}