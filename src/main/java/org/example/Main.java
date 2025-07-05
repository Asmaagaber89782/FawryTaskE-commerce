package org.example;

import org.example.Carts.Cart;
import org.example.Carts.Item;
import org.example.Carts.Pricing.ShippingFeeCalc;
import org.example.Carts.Pricing.PricingRule;
import org.example.Carts.Pricing.ShippingPerKG;
import org.example.Carts.Pricing.ShippingRule;
import org.example.Carts.Validation.BalanceValidation;
import org.example.Carts.Validation.ExpiryValidattion;
import org.example.Carts.Validation.StockValidation;
import org.example.Carts.Validation.ValidationCart;
import org.example.Customer.Customer;
import org.example.Products.MIlk;
import org.example.Products.MobileScratchCards;
import org.example.Products.Phone;
import org.example.Products.Product;

import org.example.Services.CheckoutService;
import org.example.Services.ConsoleReceiptPrinter;
import org.example.Services.PricingService;
import org.example.Services.Printer;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
    Product Milk = new MIlk(" juhayna milk ", 70, 20, LocalDate.now().plusDays(2), 1.5);
        Product phone = new Phone("Iphone 15 pro max", 150000, 5, 0.2);
        Product card = new MobileScratchCards(LocalDate.now().plusDays(1),"ScratchCard", 20, 50);

        Customer customer = new Customer("Asmaa",1000000);
        Cart cart = new Cart();
        cart.addItem(Milk, 2);
        cart.addItem(phone, 1);

        List<PricingRule> rules = List.of(
                new ShippingRule(new ShippingPerKG())
        );
        PricingService pricingService = new PricingService(rules);

        ValidationCart validator = new ExpiryValidattion();
        validator.setNext(new BalanceValidation(new ShippingPerKG())).setNext(new StockValidation());


        ShippingFeeCalc shippingCalc = new ShippingPerKG();
        Printer printer = new ConsoleReceiptPrinter();
        CheckoutService service = new CheckoutService(validator, shippingCalc, printer, pricingService);

        service.checkout(customer, cart);
    }
}