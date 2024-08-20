package org.example.job;

import org.example.document.MedicalBook;

/**
 * Класс профессии повар
 */
public class Cook extends Job implements MedicalBook {

    @Override
    public String getDocumentMedicalBook() {
        return document.getDocumentMedicalBook();
    }

    @Override
    public String getJob() {
        return "работает поваром";
    }
}
