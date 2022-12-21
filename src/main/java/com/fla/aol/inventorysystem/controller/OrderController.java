package com.fla.aol.inventorysystem.controller;

import com.fla.aol.inventorysystem.dto.response.Data;
import com.fla.aol.inventorysystem.dto.request.CreateOrder;
import com.fla.aol.inventorysystem.dto.response.CreateOrderResponse;
import com.fla.aol.inventorysystem.dto.response.GetOrderResponse;
import com.fla.aol.inventorysystem.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/orders")
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Data<CreateOrderResponse>> createOrder(@RequestBody CreateOrder createOrder){
        return new ResponseEntity<>(new Data<>(orderService.createOrder(createOrder)), HttpStatus.CREATED);
    }

    @GetMapping("/{orderID}")
    public ResponseEntity<Data<GetOrderResponse>> getOrder(@PathVariable("orderID")UUID orderID){
        return new ResponseEntity<>(new Data<>(orderService.getOrder(orderID)), HttpStatus.OK);
    }


}
