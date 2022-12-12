package com.fla.aol.inventorysystem.product.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class ProductLocationDTO {

    private final Integer warehouseID;
    private final Integer section;
}
