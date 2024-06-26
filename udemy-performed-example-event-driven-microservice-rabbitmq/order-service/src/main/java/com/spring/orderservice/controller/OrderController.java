package com.spring.orderservice.controller;

import com.spring.orderservice.dto.Order;
import com.spring.orderservice.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class OrderController {

    private OrderService orderService;

    @PostMapping("/orders")
    public String placeOrder(@RequestBody Order order){
        return orderService.placeOrder(order);
    }
}
