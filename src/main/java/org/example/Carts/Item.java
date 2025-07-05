package org.example.Carts;

import org.example.Products.Product;
import org.example.Products.Shippable;

public class Item {
    public Product product;
    public int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return product.getPrice() * quantity;
    }

    public double getWeight() {
        if (product instanceof Shippable shippableProduct) {
            return shippableProduct.getWeight() * quantity;
        }
        return 0;
    }


}

