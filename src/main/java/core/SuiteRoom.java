package core;

public class SuiteRoom extends Room {

    public SuiteRoom(int roomNumber, double basePrice) {
        super(roomNumber, basePrice);
    }

    @Override
    public double calculatePrice(int numberOfDays) {
        return (getBasePrice() + 30) * numberOfDays;
    }
}
