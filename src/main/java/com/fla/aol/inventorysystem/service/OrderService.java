package com.fla.aol.inventorysystem.service;

import com.fla.aol.inventorysystem.dto.request.CreateOrder;
import com.fla.aol.inventorysystem.dto.response.CreateOrderResponse;
import com.fla.aol.inventorysystem.dto.response.GetOrderResponse;

import javax.validation.Valid;
import java.util.UUID;

public interface OrderService {
    CreateOrderResponse createOrder(@Valid CreateOrder createOrder);
    GetOrderResponse getOrder(UUID orderID);
}
