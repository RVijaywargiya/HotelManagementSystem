package org.example;

public class CreditCardProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        return false;
    }

    @Override
    public boolean refund(double amount) {
        return false;
    }
}
