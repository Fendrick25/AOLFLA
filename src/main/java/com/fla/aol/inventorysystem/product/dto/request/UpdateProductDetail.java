package com.fla.aol.inventorysystem.product.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@AllArgsConstructor
public class UpdateProductDetail {

    @NotNull
    private final Integer id;
    @NotNull
    private final Double weight;
    @NotNull
    private final String description;
}
