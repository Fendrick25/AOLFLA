package com.fla.aol.inventorysystem.product.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@Builder
@RequiredArgsConstructor
public class ProductDetailDTO {

    @NotNull
    private final Double weight;
    @NotNull
    private final String description;
}
