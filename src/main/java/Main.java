import core.*;
import enums.PaymentType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Room room1 = new SingleRoom(101, 33);
        Room room2 = new DeluxeRoom(102, 33);
        Room room3 = new SuiteRoom(103, 33);

        List<Room> rooms = List.of(room1, room2, room3);

//        rooms.stream().forEach( room -> System.out.println(room.getRoomNumber().toString()));

         List<Booking> bookings = new ArrayList<>();

         Customer customer1 = new Customer("John", "johndoe@gmail.com", "22344");

         Payment payment = new Payment(23, PaymentType.UPI);

         Booking booking1 = new Booking(customer1, rooms, LocalDate.of(2026,2,2), LocalDate.of(2026, 2, 4), payment);

         booking1.confirmBooking();




    }
}