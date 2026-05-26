package core;

public class SingleRoom extends Room {

    public SingleRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculatePrice(int numberOfDays) {
        return (getBasePrice() + 10) * numberOfDays;
    }
}
