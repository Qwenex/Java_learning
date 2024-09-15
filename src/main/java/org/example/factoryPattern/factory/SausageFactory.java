package org.example.factoryPattern.factory;

import org.example.factoryPattern.product.Product;
import org.example.factoryPattern.product.SausageProduct;

public class SausageFactory implements Factory {

    @Override
    public Product createProduct() {
        return new SausageProduct();
    }
}
