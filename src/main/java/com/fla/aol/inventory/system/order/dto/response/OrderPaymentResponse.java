package com.fla.aol.inventory.system.order.dto.response;

import com.fla.aol.inventory.system.order.valueobject.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.UUID;

@Getter
@Builder
@AllArgsConstructor
public class OrderPaymentResponse {

    private final UUID orderID;
    private final OrderStatus orderStatus;
}
