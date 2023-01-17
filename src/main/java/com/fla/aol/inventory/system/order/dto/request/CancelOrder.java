package com.fla.aol.inventory.system.order.dto.request;

import com.fla.aol.inventory.system.order.valueobject.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.util.UUID;

@Getter
@Builder
@RequiredArgsConstructor
public class CancelOrder {
    @NotNull
    private final UUID orderId;
    @NotNull
    private final OrderStatus orderStatus;
}
