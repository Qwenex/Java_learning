package org.example.decoratorPattern;

/**
 * Очищенные овощи
 */
public class PeeledVegetables extends WashedVegetables {

    public String cook() {
        return super.cook() + "\n Овощи были очищены";
    }
}