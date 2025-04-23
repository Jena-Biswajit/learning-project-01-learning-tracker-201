package com.example.dynamicdispatch;

// Step 2: Concrete implementations
public class CreditCardProcessor implements PaymentProcessor {
    public String processPayment(double amount) {
        return "Paid ₹" + amount + " using Credit Card.";
    }
}

class PayPalProcessor implements PaymentProcessor {
    public String processPayment(double amount) {
        return "Paid ₹" + amount + " using PayPal.";
    }
}