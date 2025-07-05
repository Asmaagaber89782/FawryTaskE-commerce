package org.example.Products;

public abstract class Product {
    protected String name;
    protected double price;

    protected int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }


    public boolean isInStock(int requiredQty) {

        return quantity >= requiredQty;

    }

    public void reduceStock(int qty) {

        this.quantity -= qty;

    }

    public String getName() {

        return name;
    }

    public double getPrice() {

        return price;
    }
}

