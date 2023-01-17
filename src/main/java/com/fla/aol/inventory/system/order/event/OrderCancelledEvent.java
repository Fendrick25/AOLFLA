package com.fla.aol.inventory.system.order.event;

import com.fla.aol.inventory.system.order.entity.OrderItem;
import lombok.Builder;
import lombok.Getter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class OrderCancelledEvent extends OrderEvent{
    @Builder
    public OrderCancelledEvent(UUID orderId, List<OrderItem> orderItems, ZonedDateTime purchasedAt) {
        super(orderId, orderItems, purchasedAt);
    }
}
