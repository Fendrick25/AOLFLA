package com.fla.aol.inventorysystem.product.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@RequiredArgsConstructor
public class CreateProduct {

    @NotNull
    private final String name;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final int quantity;
    @NotNull
    private final ProductDetailDTO productDetail;
    @NotNull
    private final ProductLocationDTO location;
    @NotNull
    private final String category;
}
