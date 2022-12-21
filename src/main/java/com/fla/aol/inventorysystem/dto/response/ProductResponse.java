package com.fla.aol.inventorysystem.dto.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.NotNull;

@Getter
@RequiredArgsConstructor
public abstract class ProductResponse{
    @NotNull
    private final Integer id;
    @NotNull
    private final String name;
}
