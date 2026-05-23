package org.example;

import core.Room;

import java.util.List;

public interface RoomAllocationStrategy {

    Room allocateRoom(List<Room> rooms);
}