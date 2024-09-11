package org.example.builder;

public class Pizza {

    private String dough;
    private String cheese;
    private String sauce;
    private String sausage;
    private String green;
    private String tomato;
    private String mushrooms;
    private String pineapple;
    private String chicken;

    public String getDough() {
        return dough;
    }

    public void setDough(String dough) {
        this.dough = dough;
    }

    public String getCheese() {
        return cheese;
    }

    public void setCheese(String cheese) {
        this.cheese = cheese;
    }

    public String getSauce() {
        return sauce;
    }

    public void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getSausage() {
        if (sausage == null) {
            sausage = "Отсутсвует";
        }
        return sausage;
    }

    public void setSausage(String sausage) {
        this.sausage = sausage;
    }

    public String getGreen() {
        if (green == null) {
            green = "Отсутсвует";
        }
        return green;
    }

    public void setGreen(String green) {
        this.green = green;
    }

    public String getTomato() {
        if (tomato == null) {
            tomato = "Отсутсвуют";
        }
        return tomato;
    }

    public void setTomato(String tomato) {
        this.tomato = tomato;
    }

    public String getMushrooms() {
        if (mushrooms == null) {
            mushrooms = "Отсутсвуют";
        }
        return mushrooms;
    }

    public void setMushrooms(String mushrooms) {
        this.mushrooms = mushrooms;
    }

    public String getPineapple() {
        if (pineapple == null) {
            pineapple = "Отсутсвуют";
        }
        return pineapple;
    }

    public void setPineapple(String pineapple) {
        this.pineapple = pineapple;
    }

    public String getChicken() {
        if (chicken == null) {
            chicken = "Отсутсвует";
        }
        return chicken;
    }

    public void setChicken(String chicken) {
        this.chicken = chicken;
    }

    @Override
    public String toString() {
        return "Ваша пицца готовится по рецепту: " +
                "\n Тесто: " + getDough() +
                "\n Сыр: " + getCheese() +
                "\n Соус: " + getSauce() +
                "\n Колбаса: " + getSausage() +
                "\n Зелень: " + getGreen() +
                "\n Помидоры: " + getTomato() +
                "\n Грибы: " + getMushrooms() +
                "\n Ананасы: " + getPineapple() +
                "\n Курица: " + getChicken() +
                "\n Приятного аппетита!";
    }
}
