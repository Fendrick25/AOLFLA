package com.fla.aol.inventory.system.order.event.listener;

import com.fla.aol.inventory.system.product.service.ProductService;
import com.fla.aol.inventory.system.order.event.OrderCancelledEvent;
import com.fla.aol.inventory.system.order.event.OrderPaidEvent;
import com.fla.aol.inventory.system.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventListener {

    private final ProductService productService;
    private final NotificationService notificationService;

    @EventListener(classes = OrderPaidEvent.class)
    public void orderPaid(OrderPaidEvent orderPaidEvent){
        productService.reduceProductStock(orderPaidEvent.getOrderItems());
        notificationService.orderPaid(orderPaidEvent);
    }

    @EventListener(classes = OrderCancelledEvent.class)
    public void orderCancelled(OrderCancelledEvent orderCancelledEvent){
        productService.rollbackProductStock(orderCancelledEvent.getOrderItems());
        notificationService.orderCancelled(orderCancelledEvent);
    }
}
