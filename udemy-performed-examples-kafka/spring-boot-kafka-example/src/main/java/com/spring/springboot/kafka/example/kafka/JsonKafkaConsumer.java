package com.spring.springboot.kafka.example.kafka;

import com.spring.springboot.kafka.example.payload.User;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class JsonKafkaConsumer {

    private static final Logger _log = LoggerFactory.getLogger(JsonKafkaConsumer.class);


    @KafkaListener(topics = "inexture_json", groupId = "myGroup")
    public void consume(User user) {
        _log.info(String.format("Message Received -> %s", user.toString()));
    }
}

