package core;

import enums.BookingStatus;
import enums.PaymentStatus;
import enums.PaymentType;

public class Payment {

    private String paymentId;
    private double amount;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
    private Booking booking;

    public Payment(double amount, PaymentType paymentType, Booking booking) {
        this.amount = amount;
        this.paymentType = paymentType;
        this.booking = booking;
        this.paymentStatus = PaymentStatus.PENDING;
        this.paymentId = "111";
    }

    public void processPayment() {
        if (booking.getStatus().equals(BookingStatus.))
    }

    refundPayment()

    generateReceipt()


}
