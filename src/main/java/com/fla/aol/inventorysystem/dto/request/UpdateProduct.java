package com.fla.aol.inventorysystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class UpdateProduct {

    @NotNull
    private final Integer id;
    @NotNull
    private final String name;
    @NotNull
    private final BigDecimal price;
    @NotNull
    private final int quantity;
}
