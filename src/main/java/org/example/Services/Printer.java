package org.example.Services;

import org.example.Carts.Item;
import org.example.Customer.Customer;

import java.util.List;

public interface Printer {
    void printReceipt(Customer customer,List<Item> items, double subtotal,double shipping, double total);

}
