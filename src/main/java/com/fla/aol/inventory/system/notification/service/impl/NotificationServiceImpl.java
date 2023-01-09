package com.fla.aol.inventory.system.notification.service.impl;

import com.fla.aol.inventory.system.order.event.OrderCancelledEvent;
import com.fla.aol.inventory.system.order.event.OrderPaidEvent;
import com.fla.aol.inventory.system.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationServiceImpl implements NotificationService {
    @Override
    public void orderPaid(OrderPaidEvent orderPaidEvent) {
        log.info("Order with id: {} paid on {}", orderPaidEvent.getOrderID(), orderPaidEvent.getPurchasedAt());
    }

    @Override
    public void orderCancelled(OrderCancelledEvent orderCancelledEvent) {
        log.info("Order with id: {} cancelled on {}", orderCancelledEvent.getOrderID(), orderCancelledEvent.getPurchasedAt());
    }
}
