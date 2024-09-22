package org.example.decoratorPattern;

/**
 * Наразанные овощи
 */
public class ChoppedVegetables extends PeeledVegetables {

    public String cook() {
        return super.cook() + "\n Овощи были нарезаны";
    }
}