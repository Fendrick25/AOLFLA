package com.fla.aol.inventory.system.order.mapper;

import com.fla.aol.inventory.system.order.dto.response.OrderPaymentResponse;
import com.fla.aol.inventory.system.product.entity.Product;
import com.fla.aol.inventory.system.order.event.OrderPaidEvent;
import com.fla.aol.inventory.system.order.dto.request.CreateOrder;
import com.fla.aol.inventory.system.order.dto.response.CreateOrderResponse;
import com.fla.aol.inventory.system.order.dto.response.GetOrderResponse;
import com.fla.aol.inventory.system.order.entity.Order;
import com.fla.aol.inventory.system.order.entity.OrderDetail;
import com.fla.aol.inventory.system.order.entity.OrderItem;
import com.fla.aol.inventory.system.order.event.OrderCancelledEvent;
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
                .orderStatus(order.getOrderStatus())
                .items(order.getItems().stream().map(this::orderItemToGetOrderResponseOrderItem).collect(Collectors.toList()))
                .build();
    }

    public OrderPaymentResponse orderToOrderPaymentResponse(Order order){
        return OrderPaymentResponse.builder()
                .orderID(order.getOrderID())
                .orderStatus(order.getOrderStatus())
                .build();
    }

    public OrderPaidEvent orderToOrderPaidEvent(Order order){
        return OrderPaidEvent.builder()
                .orderID(order.getOrderID())
                .orderItems(order.getItems())
                .purchasedAt(order.getOrderDetail().getPurchaseDate())
                .build();
    }

    public OrderCancelledEvent orderToOrderCancelledEvent(Order order){
        return OrderCancelledEvent.builder()
                .orderID(order.getOrderID())
                .orderItems(order.getItems())
                .purchasedAt(order.getOrderDetail().getPurchaseDate())
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
