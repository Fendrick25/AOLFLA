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
