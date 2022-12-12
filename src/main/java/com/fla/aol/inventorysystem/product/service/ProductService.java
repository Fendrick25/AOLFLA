package com.fla.aol.inventorysystem.product.service;

import com.fla.aol.inventorysystem.product.dto.request.*;
import com.fla.aol.inventorysystem.product.dto.response.*;

import javax.validation.Valid;

public interface ProductService {

    CreateProductResponse createProduct(@Valid CreateProduct createProduct);
    UpdateProductResponse updateProduct(@Valid UpdateProduct updateProduct);
    UpdateProductDetailResponse updateProductDetail(@Valid UpdateProductDetail updateProductDetail);
    UpdateProductLocationResponse updateProductLocation(@Valid UpdateProductLocation updateProductLocation);
    UpdateProductCategoryResponse updateProductCategory(@Valid UpdateProductCategory updateProductCategory);
    GetProductResponse getProduct(Integer productID);
    void deleteProduct(Integer productID);


}
