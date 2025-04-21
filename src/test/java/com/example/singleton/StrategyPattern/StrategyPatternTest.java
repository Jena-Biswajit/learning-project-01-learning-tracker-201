package com.example.singleton.StrategyPattern;

import com.example.strategy.CreditCardPayment;import com.example.strategy.ShoppingCart;import com.example.strategy.UPIPayment;import org.junit.jupiter.api.Test;

public class StrategyPatternTest {

    @Test
    public void testCreditCardPayment() {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9999"));
        cart.checkout(500);  // Output: Paid 500 using Credit Card: 1234-5678-9999
    }

    @Test
    public void testUPIPayment() {
        ShoppingCart cart = new ShoppingCart();
        cart.setPaymentStrategy(new UPIPayment("user@upi"));
        cart.checkout(300);  // Output: Paid 300 using UPI ID: user@upi
    }
}