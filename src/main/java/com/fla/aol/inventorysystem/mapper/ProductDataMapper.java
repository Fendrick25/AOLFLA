package com.fla.aol.inventorysystem.mapper;

import com.fla.aol.inventorysystem.dto.request.ProductDetailDTO;
import com.fla.aol.inventorysystem.dto.response.*;
import com.fla.aol.inventorysystem.entity.Product;
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
