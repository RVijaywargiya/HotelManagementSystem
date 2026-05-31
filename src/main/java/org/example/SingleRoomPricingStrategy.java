package org.example;

import core.Room;

public class SingleRoomPricingStrategy implements PricingStrategy{

    @Override
    public double calculatePrice(Room room, int numberOfDays) {
        return 0;
    }
}
