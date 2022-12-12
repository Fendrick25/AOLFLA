package com.fla.aol.inventorysystem.product.dto.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public class UpdateProductLocation {
    @NotNull
    private final Integer id;
    @NotNull
    private final ProductLocationDTO location;
}
