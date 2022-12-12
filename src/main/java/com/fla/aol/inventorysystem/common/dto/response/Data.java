package com.fla.aol.inventorysystem.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Data <T>{
    private final T data;
}
