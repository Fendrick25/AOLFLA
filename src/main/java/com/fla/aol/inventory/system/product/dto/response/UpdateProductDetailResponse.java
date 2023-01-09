package com.fla.aol.inventory.system.product.dto.response;

import com.fla.aol.inventory.system.product.dto.request.ProductDetailDTO;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class UpdateProductDetailResponse extends ProductResponse{

    @NotNull
    private final ProductDetailDTO productDetail;

    @Builder
    public UpdateProductDetailResponse(@NotNull Integer id, @NotNull String name, ProductDetailDTO productDetail) {
        super(id, name);
        this.productDetail = productDetail;
    }
}
