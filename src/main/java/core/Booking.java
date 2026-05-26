package core;

import enums.BookingStatus;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;

public class Booking {

    private String bookingId;
    private Customer customer;
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
        this.payment = payment;
        this.status = BookingStatus.CREATED;
    }

    public void confirmBooking() {
        generateBookingId();
        for (Room room : rooms) {
            room.occupyRoon();
        }
        this.status = BookingStatus.CONFIRMED;
    }

    private void generateBookingId() {
        this.bookingId = UUID.randomUUID().toString();
    }

    public void cancelBooking() {
        this.status = BookingStatus.CANCELLED;
        for (Room room : rooms) {
            room.vacateRoom();
        }
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

    }

    public void updateBookingDates(LocalDate checkInDate, LocalDate checkOutDate) {
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
    }

    public BookingStatus getStatus() {
        return status;
    }
}
