package com.fla.aol.inventorysystem.service;

import com.fla.aol.inventorysystem.dto.request.*;
import com.fla.aol.inventorysystem.dto.response.*;

import javax.validation.Valid;

public interface ProductService {

    CreateProductResponse createProduct(@Valid CreateProduct createProduct);
    UpdateProductResponse updateProduct(@Valid UpdateProduct updateProduct);
    UpdateProductDetailResponse updateProductDetail(@Valid UpdateProductDetail updateProductDetail);
    GetProductResponse getProduct(Integer productID);
    void deleteProduct(Integer productID);


}
