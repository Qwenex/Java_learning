package org.example.factoryPattern;

import org.example.factoryPattern.product.Product;

/**
 * Магазин который торгует определенной продукцией
 */
public class Shop {

    private final String name;
    private final Product productsForSale;

    public Shop(String name, Product productsForSale) {
        this.name = name;
        this.productsForSale = productsForSale;
    }

    public String getName() {
        return name;
    }

    public Product getProductsForSale() {
        return productsForSale;
    }

    @Override
    public String toString() {
        return String.format("\nМагазин \"%s\" продает %s. Средняя цена товара: %s", name, productsForSale.getName(), productsForSale.getPrice());
    }
}
