package com.fla.aol.inventory.system.product.service;

import com.fla.aol.inventory.system.product.dto.request.CreateProduct;
import com.fla.aol.inventory.system.product.dto.request.UpdateProduct;
import com.fla.aol.inventory.system.product.dto.request.UpdateProductDetail;
import com.fla.aol.inventory.system.product.dto.response.CreateProductResponse;
import com.fla.aol.inventory.system.product.dto.response.GetProductResponse;
import com.fla.aol.inventory.system.product.dto.response.UpdateProductDetailResponse;
import com.fla.aol.inventory.system.product.dto.response.UpdateProductResponse;
import com.fla.aol.inventory.system.order.entity.OrderItem;

import javax.validation.Valid;
import java.util.List;

public interface ProductService {

    CreateProductResponse createProduct(@Valid CreateProduct createProduct);
    UpdateProductResponse updateProduct(@Valid UpdateProduct updateProduct);
    UpdateProductDetailResponse updateProductDetail(@Valid UpdateProductDetail updateProductDetail);
    void reduceProductStock(List<OrderItem> orderItems);
    void rollbackProductStock(List<OrderItem> orderItems);
    GetProductResponse getProduct(Integer productID);
    void deleteProduct(Integer productID);


}
