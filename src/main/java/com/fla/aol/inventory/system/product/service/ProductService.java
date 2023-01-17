package com.fla.aol.inventory.system.product.service;

import com.fla.aol.inventory.system.product.dto.request.CreateProduct;
import com.fla.aol.inventory.system.product.dto.response.CreateProductResponse;
import com.fla.aol.inventory.system.product.dto.response.GetProductResponse;
import com.fla.aol.inventory.system.order.entity.OrderItem;

import javax.validation.Valid;
import java.util.List;

public interface ProductService {

    CreateProductResponse createProduct(@Valid CreateProduct createProduct);
    void reduceProductStock(List<OrderItem> orderItems);
    void rollbackProductStock(List<OrderItem> orderItems);
    GetProductResponse getProduct(Integer productId);
    void deleteProduct(Integer productId);


}
