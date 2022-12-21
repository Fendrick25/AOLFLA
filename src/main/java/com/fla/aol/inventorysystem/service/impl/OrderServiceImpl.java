package com.fla.aol.inventorysystem.service.impl;

import com.fla.aol.inventorysystem.exception.ResourceNotFoundException;
import com.fla.aol.inventorysystem.dto.request.CreateOrder;
import com.fla.aol.inventorysystem.dto.response.CreateOrderResponse;
import com.fla.aol.inventorysystem.dto.response.GetOrderResponse;
import com.fla.aol.inventorysystem.entity.Order;
import com.fla.aol.inventorysystem.mapper.OrderDataMapper;
import com.fla.aol.inventorysystem.repository.OrderJpaRepository;
import com.fla.aol.inventorysystem.service.OrderService;
import com.fla.aol.inventorysystem.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

@Service
@Validated
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDataMapper orderDataMapper;
    private final OrderJpaRepository orderJpaRepository;
    private final ProductJpaRepository productJpaRepository;

    @Override
    public CreateOrderResponse createOrder(CreateOrder createOrder) {
        Order order = orderDataMapper.createOrderToOrder(createOrder);
        order.getItems().forEach(orderItem -> {
            orderItem.setProduct(productJpaRepository.findById(orderItem.getProduct().getId()).orElseThrow(() -> new ResourceNotFoundException("Product not found")));
        });
        order.initializeOrder();
        return orderDataMapper.orderToCreateOrderResponse(orderJpaRepository.save(order));
    }

    @Override
    public GetOrderResponse getOrder(UUID orderID) {
        Order order = orderJpaRepository.findById(orderID).orElseThrow(() -> new ResourceNotFoundException("Order not found"));
        return orderDataMapper.orderToGetOrderResponse(order);
    }





}
