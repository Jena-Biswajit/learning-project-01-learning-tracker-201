package com.example.dynamicdispatch;

public class DynamicDispatchExample {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        // The actual method called is decided at runtime 🔽
        System.out.println(service.makePayment(new CreditCardProcessor(), 500));
        System.out.println(service.makePayment(new PayPalProcessor(), 800));
    }
}
