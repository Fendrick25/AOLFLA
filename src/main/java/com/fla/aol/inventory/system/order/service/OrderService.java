package com.fla.aol.inventory.system.order.service;

import com.fla.aol.inventory.system.order.dto.request.CreateOrder;
import com.fla.aol.inventory.system.order.dto.request.PayOrder;
import com.fla.aol.inventory.system.order.dto.response.CreateOrderResponse;
import com.fla.aol.inventory.system.order.dto.response.OrderPaymentResponse;
import com.fla.aol.inventory.system.order.dto.response.GetOrderResponse;

import javax.validation.Valid;
import java.util.UUID;

public interface OrderService {
    CreateOrderResponse createOrder(@Valid CreateOrder createOrder);
    GetOrderResponse getOrder(UUID orderID);
    OrderPaymentResponse payOrder(@Valid PayOrder payOrder);
    OrderPaymentResponse cancelOrder(UUID orderID);
}
