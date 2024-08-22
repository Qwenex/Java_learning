package org.example.job;

import org.example.document.Document;
import org.example.document.MedicalBook;

/**
 * Класс профессии повар
 */
public class Cook extends Job implements MedicalBook {

    private final Document medicalBookDocument;

    public Cook(Document medicalBookDocument) {
        this.medicalBookDocument = medicalBookDocument;
    }

    @Override
    public Document getDocumentMedicalBook() {
        return medicalBookDocument;
    }

    @Override
    public String getNameJob() {
        return "Повар";
    }

    @Override
    public String toString() {
        return String.format("%s. Документы: {%s}",super.toString(), medicalBookDocument);
    }
}