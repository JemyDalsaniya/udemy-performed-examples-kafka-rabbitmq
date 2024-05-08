package com.spring.order.service.service;

import com.spring.base.domains.dto.Order;
import com.spring.base.domains.dto.OrderEvent;
import com.spring.order.service.kafka.OrderProducer;
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

        return "Order placed successfully ...";
    }
}
