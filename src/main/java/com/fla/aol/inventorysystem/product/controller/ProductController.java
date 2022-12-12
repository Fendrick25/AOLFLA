package com.fla.aol.inventorysystem.product.controller;

import com.fla.aol.inventorysystem.common.dto.response.Data;
import com.fla.aol.inventorysystem.product.dto.request.*;
import com.fla.aol.inventorysystem.product.dto.response.*;
import com.fla.aol.inventorysystem.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/products")
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Data<CreateProductResponse>> createProduct(@RequestBody CreateProduct createProduct){
        return new ResponseEntity<>(new Data<>(productService.createProduct(createProduct)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Data<UpdateProductResponse>> updateProduct(@RequestBody UpdateProduct updateProduct){
        return new ResponseEntity<>(new Data<>(productService.updateProduct(updateProduct)), HttpStatus.OK);
    }

    @PutMapping("/details")
    public ResponseEntity<Data<UpdateProductDetailResponse>> updateProductDetail(@RequestBody UpdateProductDetail updateProductDetail){
        return new ResponseEntity<>(new Data<>(productService.updateProductDetail(updateProductDetail)), HttpStatus.OK);
    }

    @PutMapping("/location")
    public ResponseEntity<Data<UpdateProductLocationResponse>> updateProductLocation(@RequestBody UpdateProductLocation updateProductLocation){
        return new ResponseEntity<>(new Data<>(productService.updateProductLocation(updateProductLocation)), HttpStatus.OK);
    }

    @PutMapping("/category")
    public ResponseEntity<Data<UpdateProductCategoryResponse>> updateProductCategory(@RequestBody UpdateProductCategory updateProductCategory){
        return new ResponseEntity<>(new Data<>(productService.updateProductCategory(updateProductCategory)), HttpStatus.OK);
    }

    @GetMapping("/{productID}")
    public ResponseEntity<Data<GetProductResponse>> getProduct(@PathVariable("productID") Integer productID){
        return new ResponseEntity<>(new Data<>(productService.getProduct(productID)), HttpStatus.OK);
    }

    @DeleteMapping("/{productID}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productID") Integer productID){
        productService.deleteProduct(productID);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
