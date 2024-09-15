package org.example.factoryPattern.product;

public class ChocolateProduct implements Product {

    @Override
    public String getName() {
        return "шоколадные изделия";
    }

    @Override
    public Integer getPrice() {
        return 120;
    }
}
