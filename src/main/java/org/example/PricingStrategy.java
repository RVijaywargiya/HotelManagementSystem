package org.example;

import core.Room;

public interface PricingStrategy {

    double calculatePrice(Room room, int numberOfDays);
}
