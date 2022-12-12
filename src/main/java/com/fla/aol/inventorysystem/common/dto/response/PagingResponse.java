package com.fla.aol.inventorysystem.common.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@Builder
public class PagingResponse<T> {
    @NotNull
    private final T data;
    @NotNull
    private final int size;
    @NotNull
    private final int total;
    @NotNull
    private final int totalPages;
    @NotNull
    private final int currentPage;

}