import core.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main() {

        Room room1 = new SingleRoom(101, 33);
        Room room2 = new DeluxeRoom(102, 33);
        Room room3 = new SuiteRoom(103, 33);

        List<Room> rooms = List.of(room1, room2, room3);

        rooms.stream().forEach( room -> System.out.println(room.getRoomNumber().toString()));

         List<Booking> bookings = new ArrayList<>();

         Customer customer1 = new Customer("John", "johndoe@gmail.com", "22344");

         Booking booking1 = new Booking(customer1, rooms, LocalDate.of(2026,2,2), LocalDate.of(2026, 2, 4));

         Payment payment = new Payment(23, booking1);


    }
}