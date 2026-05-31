package core;

import enums.BookingStatus;
import enums.PaymentStatus;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

public class Booking {

    private String bookingId;
    private final Customer customer;
    private List<Room> rooms;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Payment payment;
    private BookingStatus status;

    public Booking(Customer customer, List<Room> rooms, LocalDate checkInDate, LocalDate checkOutDate, Payment payment) {
        if (checkOutDate.isBefore(checkInDate)) {
            throw new IllegalArgumentException("Invalid booking dates");
        }
        this.customer = customer;
        this.rooms = rooms;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = BookingStatus.CREATED;
        this.payment = payment;
    }

    public void confirmBooking() {
        double billAmount = calculateBill();
        if (Double.compare(billAmount, payment.getAmount()) == 0) {
            payment.processPayment();
            bookingId = generateBookingId();
            for (Room room : rooms) {
                room.occupyRoom();
            }
            status = BookingStatus.CONFIRMED;
        } else {
            System.out.println("Please pay the whole amount");
        }
    }

    private String generateBookingId() {
        bookingId = UUID.randomUUID().toString();
        return bookingId;

    }

    public void cancelBooking() {
        status = BookingStatus.CANCELLED;
        for (Room room : rooms) {
            room.vacateRoom();
        }
        payment.refundPayment();
    }

    public double calculateBill() {
        long days = ChronoUnit.DAYS.between(checkInDate, checkOutDate);

        double total = 0;

        for (Room room : rooms) {
            total += room.calculatePrice((int) days);
        }

        return total;
    }

    public void generateInvoice() {
        System.out.println("Invoice generated for booking " + bookingId);
    }

    public void updateBookingDates(LocalDate checkInDate, LocalDate checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus bookingStatus) {
        this.status = bookingStatus;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public String getBookingId() {
        return bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public Payment getPayment() {
        return payment;
    }
}
