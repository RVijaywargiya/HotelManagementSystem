package org.example;

public class CashProcessor implements PaymentProcessor{
    @Override
    public boolean processPayment(double amount) {
        return false;
    }

    @Override
    public boolean refund(double amount) {
        return false;
    }
}
