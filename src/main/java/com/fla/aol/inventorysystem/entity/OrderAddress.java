package com.fla.aol.inventorysystem.entity;

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
