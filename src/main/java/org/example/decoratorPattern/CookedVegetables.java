package org.example.decoratorPattern;

/**
 * Сваренные готовые овощи
 */
public class CookedVegetables extends ChoppedVegetables {

    public String cook() {
        return super.cook() + "\n Овощи пригтовлены!";
    }
}