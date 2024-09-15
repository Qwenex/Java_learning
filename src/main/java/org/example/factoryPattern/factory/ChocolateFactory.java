package org.example.factoryPattern.factory;

import org.example.factoryPattern.product.ChocolateProduct;
import org.example.factoryPattern.product.Product;

public class ChocolateFactory implements Factory {

    @Override
    public Product createProduct() {
        return new ChocolateProduct();
    }
}
