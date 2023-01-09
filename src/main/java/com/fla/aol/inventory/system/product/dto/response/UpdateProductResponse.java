package com.fla.aol.inventory.system.product.dto.response;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class UpdateProductResponse extends ProductResponse{

    @NotNull
    private final BigDecimal price;
    @NotNull
    private final int quantity;

    @Builder
    public UpdateProductResponse(@NotNull Integer id, @NotNull String name, BigDecimal price, int quantity) {
        super(id, name);
        this.price = price;
        this.quantity = quantity;
    }
}
