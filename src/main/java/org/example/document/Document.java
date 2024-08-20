package org.example.document;

import java.time.LocalDate;
import java.util.Random;

/**
 * Генирация рандомного документа высшего образования и медецинской книжки.
 */
public class Document {

    public String getDocumentHigherEducation() {
        Random rnd = new Random();
        Integer rndNumberDocument = rnd.nextInt(9999);
        Integer rndSerialDocument = rnd.nextInt(999999);
        // Рандомная дата от 01.01.1970 до 31.12.2024
        LocalDate rndDate = LocalDate.ofEpochDay(rnd.nextInt(20088));
        return String.format("Высшее образование. номер %s, серия %s, дата получения %s.", rndNumberDocument, rndSerialDocument, rndDate);
    }

    public String getDocumentMedicalBook() {
        Random rnd = new Random();
        Integer rndNumberDocument = rnd.nextInt(9999);
        Integer rndSerialDocument = rnd.nextInt(999999);
        // Рандомная дата от 01.01.1970 до 31.12.2024
        LocalDate rndDate = LocalDate.ofEpochDay(rnd.nextInt(20088));
        return String.format("Медицинская книжка. номер %s, серия %s, дата получения %s.", rndNumberDocument, rndSerialDocument, rndDate);
    }
}