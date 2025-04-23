package com.example.dynamicdispatch;

// Step 3: Caller method
public class PaymentService {
    public String makePayment(PaymentProcessor processor, double amount) {
        return processor.processPayment(amount); // 🔥 Dynamic Dispatch
    }
}