package com.fla.aol.inventorysystem.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Builder
@AllArgsConstructor
public class OrderDetail {
    private String recipientName;
    @Setter
    private ZonedDateTime purchaseDate;
}
