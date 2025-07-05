package org.example.Services;

import org.example.Carts.Cart;
import org.example.Carts.Item;
import org.example.Carts.Pricing.ShippingFeeCalc;
import org.example.Carts.Validation.ValidationCart;
import org.example.Customer.Customer;

public class CheckoutService {
    private final ValidationCart validatorChain;
    private final ShippingFeeCalc shippingCalculator;
    private final Printer receiptPrinter;
    private final PricingService pricingService;

    public CheckoutService(ValidationCart validatorChain,
                           ShippingFeeCalc shippingCalculator,
                           Printer receiptPrinter,
                           PricingService pricingService) {
        this.validatorChain = validatorChain;
        this.shippingCalculator = shippingCalculator;
        this.receiptPrinter = receiptPrinter;
        this.pricingService = pricingService;
    }

    public void checkout(Customer customer, Cart cart) {
        validatorChain.handle(customer, cart);

        double subtotal = cart.getSubtotal();
        double total = pricingService.calculateFinalPrice(subtotal, cart, customer);

        for (Item item : cart.getItems()) {
            item.product.reduceStock(item.quantity);
        }

        customer.deductBalance(total);

        double shipping = shippingCalculator.calculate(cart.getItems());

        receiptPrinter.printReceipt(customer, cart.getItems(), subtotal, shipping, total);
        cart.clear();
    }
}

