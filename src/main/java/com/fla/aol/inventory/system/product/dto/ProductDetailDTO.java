package com.fla.aol.inventory.system.product.dto;

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
