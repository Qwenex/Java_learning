package utils;

import java.util.Random;

/**
 * Класс рандомная генерация
 */
public class RandomGenerate {

    /**
     * Рандомная генирация ФИО человека
     * @return ФИО
     */
    public static String randomFio() {
        String[] secondNamesMale = {
                "Иванов", "Петров", "Сидоров", "Лапшин", "Поляков", "Волков", "Карасиков", "Цветочкин", "Чичиков", "Кошкин"
        };

        String[] namesMale = {
                "Иван", "Сергей", "Олег", "Ян", "Андрей", "Николай", "Дмитрий", "Денис", "Алексей", "Артем"
        };

        String[] lastNamesMale = {
                "Иванович", "Сергеевич", "Дмитриевич", "Алексеевич", "Денисович", "Глебович", "Николаевич", "Петрович", "Андреевич", "Александрович"
        };

        String[] secondNamesFemale = {
                "Иванова", "Петрова", "Сидорова", "Лапшина", "Полякова", "Волкова", "Карасикова", "Цветочкина", "Чичикова", "Кошкина"
        };

        String[] namesFemale = {
                "Анна", "Екатерина", "Зульфия", "Ольга", "Оксана", "Светлана", "Лариса", "Александра", "Алиса", "Мария"
        };

        String[] lastNamesFemale = {
                "Ивановна", "Сергеевна", "Дмитриевна", "Алексеевна", "Денисовна", "Глебовна", "Николаевна", "Петровна", "Андреевна", "Александровна"
        };

        String[] sex = {
                "Мужской", "Женский"
        };

        Random rnd = new Random();
        String sexSelect = (sex[rnd.nextInt(sex.length)]);

        if (sexSelect.equals("Мужской")) {
            String secondNameMale = (secondNamesMale[rnd.nextInt(secondNamesMale.length)]);
            String nameMale = (namesMale[rnd.nextInt(namesMale.length)]);
            String lastNameMale = (lastNamesMale[rnd.nextInt(lastNamesMale.length)]);
            return String.format("%s %s %s", secondNameMale, nameMale, lastNameMale);
        } else {
            String secondNameFemale = (secondNamesFemale[rnd.nextInt(secondNamesFemale.length)]);
            String nameFemale = (namesFemale[rnd.nextInt(namesFemale.length)]);
            String lastNameFemale = (lastNamesFemale[rnd.nextInt(lastNamesFemale.length)]);
            return String.format("%s %s %s", secondNameFemale, nameFemale, lastNameFemale);
        }
    }

    /**
     * Рандомная генерация возраста трудоспособного человека
     * @return Рандомный возраст от 18 до 65 лет
     */
    public static Integer randomAge() {
        Random rnd = new Random();
        return rnd.nextInt(65 - 18) + 18;
    }




}
