package org.example.Carts.Validation;

import org.example.Carts.Cart;
import org.example.Customer.Customer;

public abstract class ValidationCart {

    protected ValidationCart next;

    public ValidationCart setNext(ValidationCart next) {
        this.next = next;
        return next;
    }

    public void handle(Customer customer, Cart cart) {
        validate(customer, cart);
        if (next != null) next.handle(customer, cart);
    }

    public abstract void validate(Customer customer, Cart cart);
}
