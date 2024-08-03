package identity;

import java.time.LocalDate;
import java.time.Period;

public class Person {

    private String name;
    private String lastName;
    private String surname;
    private LocalDate birthDay;
    private String sex;
    private String citizenship;
    private Integer height;
    private Integer weight;

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurname() {
        return surname;
    }

    public LocalDate getBirthDay() {
        return birthDay;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setSex(String sex) {
        if (sex == "Мужской" || sex == "Женский") {
            this.sex = sex;
        } else {
            this.sex = "Пол не определен";
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

    public Person(String lastName, String name, LocalDate birthDay) {
        this.setLastName(lastName);
        this.setName(name);
        this.setBirthDay(birthDay);
    }

    /**
     * Получить ФИО человека
     * @return ФИО
     */
    public String fullName() {
        return String.format("%s %s %s", lastName, name, surname);
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
}
