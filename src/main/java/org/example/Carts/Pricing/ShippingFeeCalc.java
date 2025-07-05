package org.example.Carts.Pricing;

import org.example.Carts.Item;
import org.example.Products.Shippable;

import java.util.List;

public interface ShippingFeeCalc {
    double calculate(List<Item> items);

}
