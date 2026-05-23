package org.example;

public interface PaymentProcessor {

    boolean processPayment(double amount);

    boolean refund(double amount);
}