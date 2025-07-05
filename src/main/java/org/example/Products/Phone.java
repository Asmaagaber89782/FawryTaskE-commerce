package org.example.Products;

public class Phone extends Product implements Shippable {
    private double weight;

    public Phone(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }

    @Override
    public double getWeight() {
        return weight;
    }


    @Override
    public String getName() {
        return name;
    }
}