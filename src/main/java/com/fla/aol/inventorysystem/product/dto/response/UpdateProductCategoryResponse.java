package com.fla.aol.inventorysystem.product.dto.response;

import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UpdateProductCategoryResponse extends ProductResponse{
    @NotNull
    private final String category;

    @Builder
    public UpdateProductCategoryResponse(@NotNull Integer id, @NotNull String name, String category) {
        super(id, name);
        this.category = category;
    }
}
