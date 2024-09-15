package org.example.factoryPattern.product;

public class SausageProduct implements Product {

    @Override
    public String getName() {
        return "колбасы, сосиски, шпики";
    }

    @Override
    public Integer getPrice() {
        return 280;
    }
}
