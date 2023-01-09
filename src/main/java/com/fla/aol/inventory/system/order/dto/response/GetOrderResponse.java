package com.fla.aol.inventory.system.order.dto.response;

import com.fla.aol.inventory.system.order.entity.OrderDetail;
import com.fla.aol.inventory.system.order.valueobject.OrderAddress;
import com.fla.aol.inventory.system.order.valueobject.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Builder
@RequiredArgsConstructor
public class GetOrderResponse {

    @NotNull
    private final UUID orderID;
    @NotNull
    private final List<OrderItem> items;
    @NotNull
    private final BigDecimal total;
    @NotNull
    private final OrderDetail orderDetail;
    @NotNull
    private final OrderAddress orderAddress;
    @NotNull
    private final OrderStatus orderStatus;

    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class OrderItem{
        @NotNull
        private final Product product;
        @NotNull
        private final BigDecimal subTotal;
    }

    @Getter
    @Builder
    @RequiredArgsConstructor
    public static class Product{
        @NotNull
        private final Integer productID;
        @NotNull
        private final String name;
        @NotNull
        private final BigDecimal price;
    }
}
