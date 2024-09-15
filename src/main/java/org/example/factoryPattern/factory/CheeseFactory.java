package org.example.factoryPattern.factory;

import org.example.factoryPattern.product.CheeseProduct;
import org.example.factoryPattern.product.Product;

public class CheeseFactory implements Factory {

    @Override
    public Product createProduct() {
        return new CheeseProduct();
    }
}
