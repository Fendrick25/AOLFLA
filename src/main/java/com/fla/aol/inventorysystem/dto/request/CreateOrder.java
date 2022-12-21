package com.fla.aol.inventorysystem.dto.request;

import com.fla.aol.inventorysystem.entity.OrderAddress;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
public class CreateOrder {
    @NotNull
    private final String recipientName;
    @NotNull
    private final OrderAddress address;
    @NotNull
    private final List<OrderItem> items;
    @Getter
    @Builder
    @AllArgsConstructor
    public static class OrderItem{
        @NotNull
        private final Integer productID;
        @NotNull
        private final int quantity;
    }
}
