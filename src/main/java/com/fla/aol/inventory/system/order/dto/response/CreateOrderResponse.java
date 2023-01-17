package com.fla.aol.inventory.system.order.dto.response;

import com.fla.aol.inventory.system.order.valueobject.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@RequiredArgsConstructor
public class CreateOrderResponse {
    @NotNull
    private final UUID orderId;
    @NotNull
    private final BigDecimal total;
    @NotNull
    private final OrderStatus orderStatus;
}
