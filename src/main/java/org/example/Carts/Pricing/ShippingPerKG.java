package org.example.Carts.Pricing;

import org.example.Carts.Item;
import org.example.Products.Shippable;

import java.util.List;

public class ShippingPerKG implements ShippingFeeCalc {
    private static final double rate=30.0;
    @Override
    public double calculate(List<Item> items) {
        double total = 0;
        for (Item item : items) {
            if(item.product  instanceof Shippable) {
                total+=item.getWeight();
            }

        }
        return total*rate;


    }
}
