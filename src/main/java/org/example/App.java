package org.example;

import org.example.job.*;
import org.example.person.Person;
import org.example.utils.RandomGenerate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App
{
    public static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        Person[] persons = {
                new Person(RandomGenerate.randomFio(),RandomGenerate.randomAge(), new Doctor(RandomGenerate.rndDocumentHigherEducation(),RandomGenerate.rndDocumentMedicalBook())),
                new Person(RandomGenerate.randomFio(),RandomGenerate.randomAge(), new Cook(RandomGenerate.rndDocumentMedicalBook())),
                new Person(RandomGenerate.randomFio(),RandomGenerate.randomAge(), new Engineer(RandomGenerate.rndDocumentHigherEducation())),
                new Person(RandomGenerate.randomFio(),RandomGenerate.randomAge(), new Loader())
        };

        for (int i = 0; i < persons.length; i++) {
            logger.info(persons[i].toString());
        }
    }
}