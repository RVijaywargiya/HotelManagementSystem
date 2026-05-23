package org.example;

import core.Room;

public class SingleRoomPricingStrategy implements PricingStrategy{

    @Override
    public double getTariff(Room room) {
        return 100;
    }
}
