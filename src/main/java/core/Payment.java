package core;

import enums.BookingStatus;
import enums.PaymentStatus;
import enums.RoomStatus;

import java.util.List;
import java.util.UUID;

public class Payment {

    private String paymentId;
    private PaymentStatus paymentStatus;
    private final double amount;
    private final Booking booking;

    public Payment(double amount, Booking booking) {
        this.amount = amount;
        this.booking = booking;
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public void processPayment() {
        double billAmount = booking.calculateBill();
        if (Double.compare(amount, billAmount) == 0) {
            paymentStatus = PaymentStatus.SUCCESS;
            paymentId = UUID.randomUUID().toString();
            System.out.println("Payment success. Payment id is " + paymentId);
            booking.setStatus(BookingStatus.CONFIRMED);
        } else {
            System.out.println("Please enter full amount to complete the payment");
            paymentStatus = PaymentStatus.FAILED;
        }
    }

    public void refundPayment() {
        if (this.paymentStatus == PaymentStatus.SUCCESS && isAnyRoomOccupied()) {
            System.out.println("A booked room has been occupied. Payment cannot be refunded now!!!");
        } else {
            this.paymentStatus = PaymentStatus.REFUNDED;
            this.booking.setStatus(BookingStatus.CANCELLED);
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
           """.formatted(
                paymentId,
                amount,
                paymentStatus
        );
    }

    private boolean isAnyRoomOccupied() {
        List<Room> occupiedRooms = this.booking.getRooms().stream().filter(room -> room.getStatus() == RoomStatus.OCCUPIED).toList();
        return !occupiedRooms.isEmpty();

    }


}
