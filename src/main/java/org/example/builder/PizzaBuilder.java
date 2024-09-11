package org.example.builder;

public class PizzaBuilder {

    private final Pizza pizza;

    public PizzaBuilder() {
        pizza = new Pizza();
    }

    public PizzaBuilder withDough(String dough) {
        pizza.setDough(dough);
        return this;
    }

    public PizzaBuilder withCheese(String cheese) {
        pizza.setCheese(cheese);
        return this;
    }

    public PizzaBuilder withSauce(String sauce) {
        pizza.setSauce(sauce);
        return this;
    }

    public PizzaBuilder withSausage(String sausage) {
        pizza.setSausage(sausage);
        return this;
    }

    public PizzaBuilder withGreen(String green) {
        pizza.setGreen(green);
        return this;
    }

    public PizzaBuilder withTomato(String tomato) {
        pizza.setTomato(tomato);
        return this;
    }

    public PizzaBuilder withMushrooms(String mushrooms) {
        pizza.setMushrooms(mushrooms);
        return this;
    }

    public PizzaBuilder withPineapple(String pineapple) {
        pizza.setPineapple(pineapple);
        return this;
    }

    public PizzaBuilder withChicken(String chicken) {
        pizza.setChicken(chicken);
        return this;
    }

    public Pizza build() {
        if (pizza.getDough() == null) {
            throw new RuntimeException("Для создания пиццы, введите обязательный компонент 'Тесто'");
        }
        if (pizza.getCheese() == null) {
            throw new RuntimeException("Для создания пиццы, введите обязательный компонент 'Сыр'");
        }
        if (pizza.getSauce() == null) {
            throw new RuntimeException("Для создания пиццы, введите обязательный компонент 'Соус'");
        }
        return pizza;
    }
}
