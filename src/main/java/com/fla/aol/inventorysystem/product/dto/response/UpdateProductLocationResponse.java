package com.fla.aol.inventorysystem.product.dto.response;

import com.fla.aol.inventorysystem.product.dto.request.ProductLocationDTO;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UpdateProductLocationResponse extends ProductResponse{
    @NotNull
    private final ProductLocationDTO location;

    @Builder
    public UpdateProductLocationResponse(@NotNull Integer id, @NotNull String name, ProductLocationDTO location) {
        super(id, name);
        this.location = location;
    }
}
