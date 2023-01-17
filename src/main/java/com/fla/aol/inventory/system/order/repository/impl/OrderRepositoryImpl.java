package com.fla.aol.inventory.system.order.repository.impl;

import com.fla.aol.inventory.system.order.entity.Order;
import com.fla.aol.inventory.system.order.repository.OrderJpaRepository;
import com.fla.aol.inventory.system.order.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order saveOrder(Order order) {
        return orderJpaRepository.save(order);
    }

    @Override
    public Order findOrder(UUID orderId) {
        return orderJpaRepository.findById(orderId).orElseThrow(() -> new ResourceAccessException("Order not found"));
    }
}
