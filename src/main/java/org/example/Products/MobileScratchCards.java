package org.example.Products;

import java.time.LocalDate;

public class MobileScratchCards extends Product implements Expirable {

    private LocalDate expiryDate;
    public MobileScratchCards(LocalDate date, String name, double price,int quantity) {
        super(name,price,quantity);
        this.expiryDate = date;
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }
}
