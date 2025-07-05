package org.example.Services;

import org.example.Carts.Cart;
import org.example.Carts.Pricing.PricingRule;
import org.example.Customer.Customer;

import java.util.List;

public class PricingService {
    private final List<PricingRule> rules;

    public PricingService(List<PricingRule> rules) {
        this.rules = rules;
    }

    public double calculateFinalPrice(double base, Cart cart, Customer customer) {
        double total = base;
        for (PricingRule rule : rules) {
            total += rule.apply(cart, customer);
        }
        return total;
    }
}
