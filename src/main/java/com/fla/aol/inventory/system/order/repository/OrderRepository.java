package com.fla.aol.inventory.system.order.repository;

import com.fla.aol.inventory.system.order.entity.Order;

import java.util.UUID;

public interface OrderRepository {
    Order saveOrder(Order order);
    Order findOrder(UUID orderID);
}
