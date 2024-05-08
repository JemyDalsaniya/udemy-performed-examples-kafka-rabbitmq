package com.spring.springboot.kafka.example.kafka;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaConsumer {


    private static final Logger _log = LoggerFactory.getLogger(KafkaConsumer.class);

    @KafkaListener(topics = "#{'${spring.kafka.template.default-topic}'}", groupId = "myGroup")
    public void consume(String message) {
        _log.info(String.format("Message Received -> %s", message));
    }
}
