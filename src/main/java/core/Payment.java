package core;

import enums.PaymentStatus;
import enums.PaymentType;

import java.util.UUID;

public class Payment {

    private String paymentId;
    private PaymentStatus paymentStatus;
    private final double amount;
    private final PaymentType paymentType;

    public Payment(double amount, PaymentType paymentType) {
        this.amount = amount;
        this.paymentType = paymentType;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public void processPayment() {
        if (paymentStatus == PaymentStatus.SUCCESS) {
            return;
        }
        paymentStatus = PaymentStatus.SUCCESS;
        paymentId = UUID.randomUUID().toString();
        System.out.println("Payment success. Payment id is " + paymentId);
    }

    public void refundPayment() {
        if (paymentStatus == PaymentStatus.SUCCESS) {
            System.out.println("Refund initiated for amount : " + amount);
            paymentStatus = PaymentStatus.REFUNDED;
        } else if (paymentStatus == PaymentStatus.REFUNDED) {
            System.out.println("Amount already refunded");
        }
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String generateReceipt() {

        return """
           Payment Id: %s
           Amount: %.2f
           Status: %s
           Payment type: %s
           """.formatted(
                paymentId,
                amount,
                paymentStatus,
                paymentType
        );
    }

    public String getPaymentId() {
        return paymentId;
    }

    public double getAmount() {
        return amount;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }
}
