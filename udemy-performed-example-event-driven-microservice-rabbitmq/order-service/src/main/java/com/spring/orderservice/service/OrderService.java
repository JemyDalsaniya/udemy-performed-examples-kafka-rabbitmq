package com.spring.orderservice.service;

import com.spring.orderservice.dto.Order;
import com.spring.orderservice.dto.OrderEvent;
import com.spring.orderservice.publisher.OrderProducer;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class OrderService {

    private OrderProducer orderProducer;

    public String placeOrder(Order order) {

        order.setOrderId(UUID.randomUUID().toString());

        OrderEvent orderEvent = new OrderEvent();
        orderEvent.setStatus("PENDING");
        orderEvent.setMessage("order status is in pending state");
        orderEvent.setOrder(order);

        orderProducer.sendMessage(orderEvent);

        return "Order placed to RabbitMQ successfully ...";
    }
}
