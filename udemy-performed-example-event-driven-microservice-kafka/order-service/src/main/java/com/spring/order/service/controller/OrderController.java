package com.spring.order.service.controller;

import com.spring.base.domains.dto.Order;
import com.spring.base.domains.dto.OrderEvent;
import com.spring.order.service.kafka.OrderProducer;
import com.spring.order.service.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

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
