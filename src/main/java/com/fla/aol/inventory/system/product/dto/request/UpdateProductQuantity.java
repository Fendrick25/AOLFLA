package com.fla.aol.inventory.system.product.dto.request;

import com.fla.aol.inventory.system.order.valueobject.OrderStatus;
import com.fla.aol.inventory.system.order.entity.OrderItem;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Getter
@Builder
@RequiredArgsConstructor
public class UpdateProductQuantity {

    private final List<OrderItem> orderItems;
    private final OrderStatus orderStatus;


}
