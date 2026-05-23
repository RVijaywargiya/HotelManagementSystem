package core;

import java.util.List;

public class Customer {

    private String customerId;
    private String name;
    private String email;
    private String phoneNumber;
    private List<Booking> bookings;

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
