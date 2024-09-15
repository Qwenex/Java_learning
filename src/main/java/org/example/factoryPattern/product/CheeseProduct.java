package org.example.factoryPattern.product;

public class CheeseProduct implements Product {

    @Override
    public String getName() {
        return "сырные изделия из сыра или со вкусом сыра";
    }

    @Override
    public Integer getPrice() {
        return 350;
    }
}
