package com.spring.springboot.kafka.example.controller;

import com.spring.springboot.kafka.example.kafka.JsonKafkaProducer;
import com.spring.springboot.kafka.example.kafka.KafkaProducer;
import com.spring.springboot.kafka.example.payload.User;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
@AllArgsConstructor
public class JsonMessageController {

    private JsonKafkaProducer kafkaProducer;

    @PostMapping("/publish")
    public ResponseEntity<String> publish(@RequestBody User user){
        kafkaProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message " +user.toString()+ " sent successfully to Topic..");
    }
}
