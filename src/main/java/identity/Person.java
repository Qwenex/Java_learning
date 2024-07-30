package identity;

public class Person {

    private static String name;
    private static String lastName;
    private static String surname;
    private String birthDay;
    private String sex;
    private String citizenship;
    private Integer height;
    private Integer weight;

    // Getters
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthDay() {
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

    //Setters
    public void setSurname(String surname) {
        this.surname = surname;
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
        if (height > 40 && height < 300) {
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
    //Конструктор
    public Person(String lastName, String name, String birthDay) {
        this.lastName = lastName;
        this.name = name;
        this.birthDay = birthDay;
    }

    //Методы
    public static String fullName() {
        return String.format("%s %s %s", lastName, name, surname);
    }
}
