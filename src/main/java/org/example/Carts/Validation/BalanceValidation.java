package org.example.Carts.Validation;

import org.example.Carts.Cart;
import org.example.Carts.Pricing.ShippingFeeCalc;
import org.example.Customer.Customer;

public class BalanceValidation extends ValidationCart{
    private final ShippingFeeCalc shippingCalculator;

    public BalanceValidation(ShippingFeeCalc shippingCalculator) {
        this.shippingCalculator = shippingCalculator;
    }

    @Override
    public void validate(Customer  customer,Cart cart) {
        double subtotal = cart.getSubtotal();
        double shipping = shippingCalculator.calculate(cart.getItems());
        double total = subtotal + shipping;
        if (!customer.canAfford(total)) {
            throw new RuntimeException("Insufficient balance");
        }

    }
}
