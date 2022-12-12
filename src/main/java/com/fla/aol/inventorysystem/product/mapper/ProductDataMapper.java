package com.fla.aol.inventorysystem.product.mapper;

import com.fla.aol.inventorysystem.product.dto.request.CreateProduct;
import com.fla.aol.inventorysystem.product.dto.request.ProductDetailDTO;
import com.fla.aol.inventorysystem.product.dto.request.ProductLocationDTO;
import com.fla.aol.inventorysystem.product.dto.response.*;
import com.fla.aol.inventorysystem.product.entity.Category;
import com.fla.aol.inventorysystem.product.entity.Product;
import com.fla.aol.inventorysystem.product.entity.ProductDetail;
import com.fla.aol.inventorysystem.product.entity.ProductLocation;
import org.springframework.stereotype.Component;

@Component
public class ProductDataMapper {
    public Product createProductToProduct(CreateProduct createProduct){
        return Product.builder()
                .name(createProduct.getName())
                .price(createProduct.getPrice())
                .quantity(createProduct.getQuantity())
                .productDetail(ProductDetail.builder()
                        .weight(createProduct.getProductDetail().getWeight())
                        .description(createProduct.getProductDetail().getDescription())
                        .build())
                .category(Category.builder()
                        .id(createProduct.getCategory())
                        .build())
                .location(ProductLocation.builder()
                        .section(createProduct.getLocation().getSection())
                        .warehouseID(createProduct.getLocation().getWarehouseID())
                        .build())
                .build();
    }

    public CreateProductResponse productToCreateProductResponse(Product product){
        return CreateProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .location(ProductLocationDTO.builder()
                        .warehouseID(product.getLocation().getWarehouseID())
                        .section(product.getLocation().getSection())
                        .build())
                .build();
    }

    public GetProductResponse productToGetProductResponse(Product product){
        return GetProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .category(product.getCategory().getName())
                .location(ProductLocationDTO.builder()
                        .warehouseID(product.getLocation().getWarehouseID())
                        .section(product.getLocation().getSection())
                        .build())
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

    public UpdateProductLocationResponse productToUpdateProductLocationResponse(Product product){
        return UpdateProductLocationResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .location(ProductLocationDTO.builder()
                        .warehouseID(product.getLocation().getWarehouseID())
                        .section(product.getLocation().getSection())
                        .build())
                .build();
    }

    public UpdateProductCategoryResponse productToUpdateProductCategoryResponse(Product product){
        return UpdateProductCategoryResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory().getName())
                .build();
    }
}
