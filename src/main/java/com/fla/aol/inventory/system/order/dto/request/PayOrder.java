package com.fla.aol.inventory.system.order.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Builder
@RequiredArgsConstructor
public class PayOrder {

    @NotNull
    private final UUID orderId;
    @NotNull
    private final BigDecimal amount;
}
