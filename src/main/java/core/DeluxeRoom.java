package core;

public class DeluxeRoom extends Room {

    public DeluxeRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculatePrice(int numberOfDays) {
        return (getBasePrice() + 20) * numberOfDays;
    }
}
