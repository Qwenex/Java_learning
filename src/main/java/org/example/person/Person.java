package org.example.person;

import java.util.Random;

/**
 * Класс персоны
 */
public class Person {

    public String[] secondNamesMale = {
            "Иванов",
            "Петров",
            "Сидоров",
            "Лапшин",
            "Поляков",
            "Волков",
            "Карасиков",
            "Цветочкин",
            "Чичиков",
            "Кошкин"
    };

    public String[] namesMale = {
            "Иван",
            "Сергей",
            "Олег",
            "Ян",
            "Андрей",
            "Николай",
            "Дмитрий",
            "Денис",
            "Алексей",
            "Артем"
    };

    public String[] lastNamesMale = {
            "Иванович",
            "Сергеевич",
            "Дмитриевич",
            "Алексеевич",
            "Денисович",
            "Глебович",
            "Николаевич",
            "Петрович",
            "Андреевич",
            "Александрович"
    };

    public String[] secondNamesFemale = {
            "Иванова",
            "Петрова",
            "Сидорова",
            "Лапшина",
            "Полякова",
            "Волкова",
            "Карасикова",
            "Цветочкина",
            "Чичикова",
            "Кошкина"
    };

    public String[] namesFemale = {
            "Анна",
            "Екатерина",
            "Зульфия",
            "Ольга",
            "Оксана",
            "Светлана",
            "Лариса",
            "Александра",
            "Алиса",
            "Мария"
    };

    public String[] lastNamesFemale = {
            "Ивановна",
            "Сергеевна",
            "Дмитриевна",
            "Алексеевна",
            "Денисовна",
            "Глебовна",
            "Николаевна",
            "Петровна",
            "Андреевна",
            "Александровна"
    };

    public String[] sex = {
            "Мужской",
            "Женский"
    };

    /**
     * Рандомная генирация ФИО человека, его возраст и пол.
     * @return ФИО, возраст, пол
     */
    public String randomFio() {
        Random rnd = new Random();
        String sexSelect = (sex[rnd.nextInt(sex.length)]);
        String secondNameMale = (secondNamesMale[rnd.nextInt(secondNamesMale.length)]);
        String nameMale = (namesMale[rnd.nextInt(namesMale.length)]);
        String lastNameMale = (lastNamesMale[rnd.nextInt(lastNamesMale.length)]);
        String secondNameFemale = (secondNamesFemale[rnd.nextInt(secondNamesFemale.length)]);
        String nameFemale = (namesFemale[rnd.nextInt(namesFemale.length)]);
        String lastNameFemale = (lastNamesFemale[rnd.nextInt(lastNamesFemale.length)]);
        Integer age = rnd.nextInt(65 - 18) + 18;

        if (sexSelect.equals("Мужской")) {
            return String.format("%s %s %s, Возраст %s, Пол %s", secondNameMale, nameMale, lastNameMale, age, sexSelect);
        } else {
            return String.format("%s %s %s, Возраст %s, Пол %s", secondNameFemale, nameFemale, lastNameFemale, age, sexSelect);
        }
    }
}
