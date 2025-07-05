package org.example.Carts.Pricing;

import org.example.Carts.Cart;
import org.example.Customer.Customer;

import java.io.Serializable;

public class ShippingRule implements PricingRule{
private  ShippingFeeCalc shippingFeeCalc;
public ShippingRule(ShippingFeeCalc shippingFeeCalc) {
    this.shippingFeeCalc = shippingFeeCalc;
}

    @Override
    public double apply(Cart cart,  Customer customer) {
        return  shippingFeeCalc.calculate(cart.getItems());
    }
}
