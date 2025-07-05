package org.example.Products;

import java.time.LocalDate;
import java.util.Date;

public class MIlk extends Product implements Expirable, Shippable {
    private LocalDate expiryDate;
    private double weight;

    public MIlk(String name, double price, int quantity, LocalDate expiryDate, double weight) {
        super(name, price, quantity);

        this.expiryDate = expiryDate;

        this.weight = weight;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public double getWeight() {
        return weight;
    }


}
