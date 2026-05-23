package core;

public class DeluxeRoom extends Room {

    public DeluxeRoom(String roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculatePrice(int numberOfDays) {
        return numberOfDays * getBasePrice();
    }
}
