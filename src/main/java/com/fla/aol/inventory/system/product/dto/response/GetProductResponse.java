package com.fla.aol.inventory.system.product.dto.response;

import com.fla.aol.inventory.system.product.valueobject.ProductLocation;
import com.fla.aol.inventory.system.product.dto.request.ProductDetailDTO;
import com.fla.aol.inventory.system.product.valueobject.ProductType;
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
    private Integer productId;
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
