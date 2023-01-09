package com.fla.aol.inventory.system.notification.service;


import com.fla.aol.inventory.system.order.event.OrderCancelledEvent;
import com.fla.aol.inventory.system.order.event.OrderPaidEvent;

public interface NotificationService {

    void orderPaid(OrderPaidEvent orderPaidEvent);
    void orderCancelled(OrderCancelledEvent orderCancelledEvent);
}
