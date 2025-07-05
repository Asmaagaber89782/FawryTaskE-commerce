package org.example.Services;

import org.example.Carts.Item;
import org.example.Customer.Customer;

import java.util.List;

public class ConsoleReceiptPrinter implements  Printer{

        @Override
        public void printReceipt(Customer customer, List<Item> items, double subtotal, double shipping, double total) {
            System.out.println("** Checkout receipt **");
            for (Item item : items) {
                System.out.printf("%dx %s %.2f\n", item.quantity, item.product.getName(), item.getTotalPrice());
            }

            System.out.println("----------------------");
            System.out.printf("Subtotal %.2f\n", subtotal);
            System.out.printf("Shipping %.2f\n", shipping);
            System.out.printf("Total %.2f\n", total);
            System.out.printf("Remaining Balance: %.2f\n", customer.getBalance());
        }
    }
