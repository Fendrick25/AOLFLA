package com.fla.aol.inventorysystem.mapper;

import com.fla.aol.inventorysystem.dto.request.CreateOrder;
import com.fla.aol.inventorysystem.dto.response.CreateOrderResponse;
import com.fla.aol.inventorysystem.dto.response.GetOrderResponse;
import com.fla.aol.inventorysystem.entity.Order;
import com.fla.aol.inventorysystem.entity.OrderDetail;
import com.fla.aol.inventorysystem.entity.OrderItem;
import com.fla.aol.inventorysystem.entity.Product;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OrderDataMapper {

    public Order createOrderToOrder(CreateOrder createOrder){
        return Order.builder()
                .items(createOrder.getItems().stream().map(this::createOrderOrderItemToOrderItem).collect(Collectors.toList()))
                .orderAddress(createOrder.getAddress())
                .orderDetail(OrderDetail.builder()
                        .recipientName(createOrder.getRecipientName())
                        .build())
                .build();
    }

    public CreateOrderResponse orderToCreateOrderResponse(Order order){
        return CreateOrderResponse.builder()
                .orderID(order.getOrderID())
                .total(order.getTotal())
                .orderStatus(order.getOrderStatus())
                .build();
    }

    public GetOrderResponse orderToGetOrderResponse(Order order){
        return GetOrderResponse.builder()
                .orderID(order.getOrderID())
                .total(order.getTotal())
                .orderAddress(order.getOrderAddress())
                .orderDetail(order.getOrderDetail())
                .items(order.getItems().stream().map(this::orderItemToGetOrderResponseOrderItem).collect(Collectors.toList()))
                .build();
    }

    private OrderItem createOrderOrderItemToOrderItem(CreateOrder.OrderItem orderItem){
        return OrderItem.builder()
                .product(Product.builder()
                        .id(orderItem.getProductID())
                        .build())
                .quantity(orderItem.getQuantity())
                .build();
    }

    private GetOrderResponse.OrderItem orderItemToGetOrderResponseOrderItem(OrderItem orderItem){
        return GetOrderResponse.OrderItem.builder()
                .product(GetOrderResponse.Product.builder()
                        .productID(orderItem.getProduct().getId())
                        .name(orderItem.getProduct().getName())
                        .price(orderItem.getProduct().getPrice())
                        .build())

                .subTotal(orderItem.getSubTotal())
                .build();
    }
}
