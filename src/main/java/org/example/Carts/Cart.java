package org.example.Carts;
import org.example.Products.Product;

import java.util.*;

public class Cart {
    private List<Item> items = new ArrayList<>();

    public void addItem(Product product, int quantity) {
        if (!product.isInStock(quantity)) {
            throw new IllegalArgumentException("Not enough stock for " + product.getName());
        }
        items.add(new Item(product, quantity));
    }

    public List<Item> getItems() {
        return items;
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public void clear() {
        items.clear();
    }
    public double getSubtotal() {
        double total=0.0;
        for(Item item : items){
            total+=item.getTotalPrice();
        }
        return total;
    }
}
