package core;

import enums.RoomStatus;

import java.util.List;

public class Hotel {

    private String hotelName;
    private List<Room> rooms;
    private List<Booking> bookings;
    private List<Employee> employees;

    public Hotel(String hotelName, List<Room> rooms, List<Employee> employees) {
        this.hotelName = hotelName;
        this.rooms = rooms;
        this.employees = employees;
    }

    void searchAvailableRooms(Room room) {



    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void removeRoom(int roomNumber) {
        Room room = findRoomByRoomNumber(roomNumber);
        if (room != null) {
            rooms.remove(room);
        }

        System.out.println("Room with entered room number " + roomNumber + " not found");
    }

    void checkIn(String bookingId) {
        Booking booking1 = findBookingByBookingId(bookingId);
        if (booking1 != null) {
            List<Room> rooms = booking1.getRooms();
            rooms.forEach(room -> room.setStatus(RoomStatus.OCCUPIED));
        } else {
            System.out.println("Booking with id " + bookingId + " not found");
        }
    }

    void checkOut(String bookingId) {
        Booking booking1 = findBookingByBookingId(bookingId);
        if (booking1 != null) {
            List<Room> rooms = booking1.getRooms();
            rooms.forEach(room -> room.setStatus(RoomStatus.AVAILABLE));
        } else {
            System.out.println("Booking with id " + bookingId + " not found");
        }
    }

    public Room findRoomByRoomNumber(int roomNumber) {
        return rooms.stream().filter(room -> room.getRoomNumber() == roomNumber).findFirst().orElse(null);
    }

    public Booking findBookingByBookingId(String bookingId) {
        return bookings.stream().filter(booking -> booking.getBookingId() == bookingId).findFirst().orElse(null);

    }


}
