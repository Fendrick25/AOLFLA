package com.fla.aol.inventory.system.order.controller;

import com.fla.aol.inventory.system.common.dto.response.Data;
import com.fla.aol.inventory.system.order.dto.request.CreateOrder;
import com.fla.aol.inventory.system.order.dto.request.PayOrder;
import com.fla.aol.inventory.system.order.dto.response.CreateOrderResponse;
import com.fla.aol.inventory.system.order.dto.response.GetOrderResponse;
import com.fla.aol.inventory.system.order.dto.response.OrderPaymentResponse;
import com.fla.aol.inventory.system.order.service.OrderService;
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

    @GetMapping("/{orderId}")
    public ResponseEntity<Data<GetOrderResponse>> getOrder(@PathVariable("orderId")UUID orderId){
        return new ResponseEntity<>(new Data<>(orderService.getOrder(orderId)), HttpStatus.OK);
    }

    @PutMapping("/pay")
    public ResponseEntity<Data<OrderPaymentResponse>> payOrder(@RequestBody PayOrder payOrder){
        return new ResponseEntity<>(new Data<>(orderService.payOrder(payOrder)), HttpStatus.OK);
    }

    @PutMapping("{orderId}/cancel")
    public ResponseEntity<Data<OrderPaymentResponse>> cancelOrder(@PathVariable("orderId") UUID orderId){
        return new ResponseEntity<>(new Data<>(orderService.cancelOrder(orderId)), HttpStatus.OK);
    }
}
