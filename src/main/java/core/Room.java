package core;

import enums.RoomStatus;

public abstract class Room {

    private final int roomNumber;
    private final double basePrice;
    private RoomStatus status;

    public Room(int roomNumber, double basePrice) {
        this.roomNumber = roomNumber;
        this.basePrice = basePrice;
        this.status = RoomStatus.AVAILABLE;
    }

    /*
        Returns true if room is available, else unavailable
         */
    public boolean checkAvailability() {
        return this.status == RoomStatus.AVAILABLE;
    }

    public void occupyRoon() {
        this.status = RoomStatus.OCCUPIED;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void vacateRoom() {
        this.status = RoomStatus.AVAILABLE;
    }

    abstract public double calculatePrice(int numberOfDays);

    void markUnderMaintenance() {
        this.status = RoomStatus.MAINTENANCE;
    }


    public void setStatus(RoomStatus status) {
        this.status = status;
    }
}
