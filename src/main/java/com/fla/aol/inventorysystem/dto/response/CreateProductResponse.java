package com.fla.aol.inventorysystem.dto.response;

import com.fla.aol.inventorysystem.valueobject.ProductLocation;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CreateProductResponse extends ProductResponse{

    @NotNull
    private final ProductLocation location;

    @Builder
    public CreateProductResponse(@NotNull Integer id, @NotNull String name, ProductLocation location) {
        super(id, name);
        this.location = location;
    }
}
