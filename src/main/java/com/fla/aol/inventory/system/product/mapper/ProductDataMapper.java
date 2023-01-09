package com.fla.aol.inventory.system.product.mapper;

import com.fla.aol.inventory.system.product.dto.response.CreateProductResponse;
import com.fla.aol.inventory.system.product.dto.response.GetProductResponse;
import com.fla.aol.inventory.system.product.dto.request.ProductDetailDTO;
import com.fla.aol.inventory.system.product.dto.response.UpdateProductDetailResponse;
import com.fla.aol.inventory.system.product.dto.response.UpdateProductResponse;
import com.fla.aol.inventory.system.product.entity.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductDataMapper {
    public CreateProductResponse productToCreateProductResponse(Product product){
        return CreateProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .location(product.getLocation())
                .build();
    }

    public GetProductResponse productToGetProductResponse(Product product){
        return GetProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .type(product.getProductType())
                .location(product.getLocation())
                .productDetail(ProductDetailDTO.builder()
                        .weight(product.getProductDetail().getWeight())
                        .description(product.getProductDetail().getDescription())
                        .build())
                .build();
    }

    public UpdateProductResponse productToUpdateProductResponse(Product product){
        return UpdateProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    public UpdateProductDetailResponse productToUpdateProductDetailResponse(Product product){
        return UpdateProductDetailResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .productDetail(ProductDetailDTO.builder()
                        .weight(product.getProductDetail().getWeight())
                        .description(product.getProductDetail().getDescription())
                        .build())
                .build();
    }
}
