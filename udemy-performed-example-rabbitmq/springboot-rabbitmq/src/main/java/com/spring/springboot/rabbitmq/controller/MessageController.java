package com.spring.springboot.rabbitmq.controller;


import com.spring.springboot.rabbitmq.publisher.RabbitMQPublisher;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class MessageController {

    private RabbitMQPublisher rabbitMQPublisher;

    @GetMapping("/publish")
    public ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        rabbitMQPublisher.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ....");
    }

}
