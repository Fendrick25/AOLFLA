package com.fla.aol.inventory.system.order.valueobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class OrderAddress {
    private String street;
    private String city;
    private String postalCode;
    private String detail;
}
