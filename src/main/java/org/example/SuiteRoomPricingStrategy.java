package org.example;

import core.Room;

public class SuiteRoomPricingStrategy implements PricingStrategy{
    @Override
    public double getTariff(Room room) {
        return 300;
    }
}
