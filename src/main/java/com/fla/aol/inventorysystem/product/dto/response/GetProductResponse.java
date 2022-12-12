package com.fla.aol.inventorysystem.product.dto.response;

import com.fla.aol.inventorysystem.product.dto.request.ProductDetailDTO;
import com.fla.aol.inventorysystem.product.dto.request.ProductLocationDTO;
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
    private ProductLocationDTO location;
    @NotNull
    private String category;
}
