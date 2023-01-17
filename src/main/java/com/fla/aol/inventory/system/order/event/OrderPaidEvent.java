package com.fla.aol.inventory.system.order.event;


import com.fla.aol.inventory.system.order.entity.OrderItem;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class OrderPaidEvent extends OrderEvent{

    @Builder
    public OrderPaidEvent(UUID orderId, List<OrderItem> orderItems, ZonedDateTime purchasedAt) {
        super(orderId, orderItems, purchasedAt);
    }
}
