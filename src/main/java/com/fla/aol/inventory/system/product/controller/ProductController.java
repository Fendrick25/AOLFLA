package com.fla.aol.inventory.system.product.controller;

import com.fla.aol.inventory.system.common.dto.response.Data;
import com.fla.aol.inventory.system.product.dto.request.CreateProduct;
import com.fla.aol.inventory.system.product.dto.response.CreateProductResponse;
import com.fla.aol.inventory.system.product.dto.response.GetProductResponse;
import com.fla.aol.inventory.system.product.service.ProductService;
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

    @GetMapping("/{productId}")
    public ResponseEntity<Data<GetProductResponse>> getProduct(@PathVariable("productId") Integer productID){
        return new ResponseEntity<>(new Data<>(productService.getProduct(productID)), HttpStatus.OK);
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("productId") Integer productId){
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
