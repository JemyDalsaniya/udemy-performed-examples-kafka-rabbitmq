package com.spring.springboot.rabbitmq.controller;


import com.spring.springboot.rabbitmq.dto.User;
import com.spring.springboot.rabbitmq.publisher.RabbitMQJsonPublisher;
import com.spring.springboot.rabbitmq.publisher.RabbitMQPublisher;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class MessageJsonController {

    private RabbitMQJsonPublisher rabbitMQPublisher;

    @PostMapping("/publish")
    public ResponseEntity<String> sendJsonMessage(@RequestBody User user){
        rabbitMQPublisher.sendJsonMessage(user);
        return ResponseEntity.ok("Json Message sent to RabbitMQ....");
    }

}
