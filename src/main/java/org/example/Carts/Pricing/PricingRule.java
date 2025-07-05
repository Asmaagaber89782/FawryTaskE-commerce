package org.example.Carts.Pricing;

import org.example.Carts.Cart;
import org.example.Customer.Customer;

public interface PricingRule {
    double apply(Cart cart, Customer customer);
}
