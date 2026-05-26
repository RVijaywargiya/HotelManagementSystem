package core;

import java.util.List;

public class Customer {

    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Booking> bookings;

    public Customer(String customerId, String name, String email, String phoneNumber, List<Booking> bookings) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.bookings = bookings;
    }

    void createBooking(Booking booking) {
        bookings.add(booking);
    }

    void cancelBooking(Booking booking) {
        bookings.remove(booking);
    }

    void viewBookingHistory() {
        bookings.forEach(System.out::println);
    }
}
