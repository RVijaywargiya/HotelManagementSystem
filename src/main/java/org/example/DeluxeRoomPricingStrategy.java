package org.example;

import core.Room;

public class DeluxeRoomPricingStrategy implements PricingStrategy{

    @Override
    public double getTariff(Room room) {
        return 200;
    }
}
