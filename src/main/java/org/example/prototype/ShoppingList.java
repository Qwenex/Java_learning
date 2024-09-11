package org.example.prototype;

public class ShoppingList implements Prototype {

    private String name;
    private Integer quantity;
    private Integer price;

    public ShoppingList(String name, Integer quantity, Integer price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public void setNewItem(String name, Integer quantity, Integer price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public Object copy() {
        return new ShoppingList(this.name, this.quantity, this.price);
    }

    @Override
    public String toString() {
        return String.format("\nТовар: %s, Кол-во: %s, Цена: %s", name, quantity, price);
    }
}
