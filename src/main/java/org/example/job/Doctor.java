package org.example.job;

import org.example.document.HigherEducation;
import org.example.document.MedicalBook;

/**
 * Класс профессии доктор
 */
public class Doctor extends Job implements HigherEducation, MedicalBook {

    @Override
    public String getDocumentHigherEducation() {
        return document.getDocumentHigherEducation();
    }

    @Override
    public String getDocumentMedicalBook() {
        return document.getDocumentMedicalBook();
    }

    @Override
    public String getJob() {
        return "работает доктором";
    }
}
