package com.fla.aol.inventorysystem.dto.response;

import com.fla.aol.inventorysystem.dto.request.ProductDetailDTO;
import com.fla.aol.inventorysystem.valueobject.ProductLocation;
import com.fla.aol.inventorysystem.valueobject.ProductType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class GetProductResponse {

    @NotNull
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    private BigDecimal price;
    @NotNull
    private int quantity;
    @NotNull
    private ProductDetailDTO productDetail;
    @NotNull
    private ProductLocation location;
    @NotNull
    private ProductType type;
}
