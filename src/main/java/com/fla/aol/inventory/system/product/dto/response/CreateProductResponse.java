package com.fla.aol.inventory.system.product.dto.response;

import com.fla.aol.inventory.system.product.valueobject.ProductLocation;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateProductResponse extends ProductResponse{
    @NotNull
    private final ProductLocation location;
    @Builder
    public CreateProductResponse(@NotNull Integer productId, @NotNull String name, ProductLocation location) {
        super(productId, name);
        this.location = location;
    }
}
