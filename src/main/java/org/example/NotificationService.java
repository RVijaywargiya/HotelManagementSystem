package org.example;

import core.Customer;

public interface NotificationService {

    void sendNotification(Customer customer, String message);
}