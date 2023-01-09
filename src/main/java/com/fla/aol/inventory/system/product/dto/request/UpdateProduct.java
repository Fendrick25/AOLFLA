package com.fla.aol.inventory.system.product.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Builder
@RequiredArgsConstructor
public class UpdateProduct {

    @NotNull
    private final Integer id;
    @NotNull
    private final String name;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final int quantity;
}
