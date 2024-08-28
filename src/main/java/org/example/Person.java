package org.example;

import exceptions.StringReaderError;

import java.io.StringReader;
import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Person {

    private String fio;
    private LocalDate birthDay;
    private String birthPlace;
    private String sex;
    private String citizenship;
    private Integer height;
    private Integer weight;
    private String phoneNumber;
    private String hairColor;

    public Person(String fio, LocalDate birthDay, String birthPlace) {
        this.fio = fio;
        this.birthDay = birthDay;
        this.birthPlace = birthPlace;
    }

    public String getFio() {
        return fio;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public String getBirthPlace() {
        return birthPlace;
    }

    public String getSex() {
        return sex;
    }

    public String getCitizenship() {
        return citizenship;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getWeight() {
        return weight;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getHairColor() {
        return hairColor;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    public void setSex(String sex) {
        if (sex.equalsIgnoreCase("Мужской") || sex.equalsIgnoreCase("Женский")) {
            this.sex = sex;
        } else {
            this.sex = "Не определен";
        }
    }

    public void setCitizenship(String citizenship) {
        this.citizenship = citizenship;
    }

    public void setHeight(Integer height) {
        if (height > 30 && height < 300) {
            this.height = height;
        } else {
            this.height = 0;
        }
    }

    public void setWeight(Integer weight) {
        if (weight > 5 && weight < 300) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setHairColor(String hairColor) {
        this.hairColor = hairColor;
    }

    /**
     * Получить возраст человека
     * @return Возраст
     */
    public Integer getAge() {
        Period period = Period.between(this.birthDay, LocalDate.now());
        return period.getYears();
    }

    /**
     * Является ли человек совершеннотеним?
     * @return Является ли человек совершеннотеним
     */
    public Boolean isAdult() {
        return getAge() >= 18;
    }

    /* Hashcode c использованием Objects.hash
    @Override
    public int hashCode() {
        return Objects.hash(fio, birthDay, birthPlace);
    }
    */

    //Hashcode без использования Objects.hash
    @Override
    public int hashCode() {
        int hash = 123;
        String lowerCaseString = fio.toLowerCase().concat(birthPlace.toLowerCase());
        try (StringReader strReader = new StringReader(lowerCaseString)) {
            while (true) {
                int i = strReader.read();
                hash += i;
                if (i == -1) {
                    break;
                }
            }
        } catch (Exception e) {
            throw new StringReaderError(lowerCaseString);
        }
        hash *= birthDay.getDayOfMonth();
        hash /= birthDay.getMonthValue();
        hash -= birthDay.getYear();
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj instanceof Person) {
            Person anotherPerson = (Person) obj;
            return fio.equalsIgnoreCase(anotherPerson.fio) && birthDay.equals(anotherPerson.birthDay) && birthPlace.equalsIgnoreCase(anotherPerson.birthPlace);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.format("Фио: %s. Дата рождения: %s. Город рождения: %s.", fio, birthDay, birthPlace);
    }
}