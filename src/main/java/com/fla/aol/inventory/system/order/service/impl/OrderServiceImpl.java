package com.fla.aol.inventory.system.order.service.impl;

import com.fla.aol.inventory.system.common.exception.InvalidStateException;
import com.fla.aol.inventory.system.order.dto.request.CreateOrder;
import com.fla.aol.inventory.system.order.dto.request.PayOrder;
import com.fla.aol.inventory.system.order.dto.response.CreateOrderResponse;
import com.fla.aol.inventory.system.order.dto.response.GetOrderResponse;
import com.fla.aol.inventory.system.order.dto.response.OrderPaymentResponse;
import com.fla.aol.inventory.system.order.entity.Order;
import com.fla.aol.inventory.system.common.exception.ResourceNotFoundException;
import com.fla.aol.inventory.system.order.mapper.OrderDataMapper;
import com.fla.aol.inventory.system.order.repository.OrderRepository;
import com.fla.aol.inventory.system.product.repository.ProductJpaRepository;
import com.fla.aol.inventory.system.order.service.OrderService;
import com.fla.aol.inventory.system.product.repository.ProductRepository;
import com.fla.aol.inventory.system.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.UUID;

@Service
@Validated
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderDataMapper orderDataMapper;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ProductService productService;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public CreateOrderResponse createOrder(CreateOrder createOrder) {
        Order order = orderDataMapper.createOrderToOrder(createOrder);
        order.getItems().forEach(orderItem -> orderItem.setProduct(productRepository.findProduct(orderItem.getProduct().getId())));
        order.initializeOrder();
        productService.reduceProductStock(order.getItems());
        return orderDataMapper.orderToCreateOrderResponse(orderRepository.saveOrder(order));
    }

    @Override
    public GetOrderResponse getOrder(UUID orderID) {
        Order order = orderRepository.findOrder(orderID);
        return orderDataMapper.orderToGetOrderResponse(order);
    }

    @Override
    public OrderPaymentResponse payOrder(PayOrder payOrder) {
        Order order = orderRepository.findOrder(payOrder.getOrderID());
        List<String> failureMessages = order.payOrder(payOrder.getAmount());
        if(!failureMessages.isEmpty())
            throw new InvalidStateException(failureMessages.toString());

        Order updatedOrder = orderRepository.saveOrder(order);
        applicationEventPublisher.publishEvent(orderDataMapper.orderToOrderPaidEvent(order));
        return orderDataMapper.orderToOrderPaymentResponse(updatedOrder);
    }

    @Override
    public OrderPaymentResponse cancelOrder(UUID orderID) {
        Order order = orderRepository.findOrder(orderID);
        List<String> failureMessages = order.cancelOrder();
        if(!failureMessages.isEmpty())
            throw new InvalidStateException(failureMessages.toString());

        Order updatedOrder = orderRepository.saveOrder(order);
        applicationEventPublisher.publishEvent(orderDataMapper.orderToOrderCancelledEvent(order));
        return orderDataMapper.orderToOrderPaymentResponse(updatedOrder);
    }
}
