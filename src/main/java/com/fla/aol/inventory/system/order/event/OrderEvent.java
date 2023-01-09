package com.fla.aol.inventory.system.order.event;

import com.fla.aol.inventory.system.order.entity.OrderItem;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@RequiredArgsConstructor
public abstract class OrderEvent {
    private final UUID orderID;
    private final List<OrderItem> orderItems;
    private final ZonedDateTime purchasedAt;
}
