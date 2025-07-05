package org.example.Carts.Validation;

import org.example.Carts.Cart;
import org.example.Carts.Item;
import org.example.Customer.Customer;
import org.example.Products.Expirable;
import org.example.Products.Product;

public class ExpiryValidattion extends ValidationCart{
    @Override
    public void validate(Customer  customer,Cart cart) {

        for (Item item : cart.getItems()) {
            Product p = item.product;
            if (p instanceof Expirable exp && exp.isExpired()) {
                throw new RuntimeException("Product" + p.getName() + "is expired");
            }
        }

    }
}
