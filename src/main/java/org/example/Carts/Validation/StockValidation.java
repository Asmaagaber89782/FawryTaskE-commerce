package org.example.Carts.Validation;

import org.example.Carts.Cart;
import org.example.Carts.Item;
import org.example.Customer.Customer;

public class StockValidation extends ValidationCart {
    @Override
    public void validate(Customer customer, Cart cart) {
        for (Item item : cart.getItems()) {
            if (!item.product.isInStock(item.quantity)) {
                throw new RuntimeException("not enough stock for" + item.product.getName());
            }
        }

    }
}
