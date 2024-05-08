package com.spring.springboot.kafka.example.kafka;

import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class KafkaProducer {


    private static final Logger _log = LoggerFactory.getLogger(KafkaProducer.class);

    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        _log.info(String.format("Message Sent %s", message));
        kafkaTemplate.send("#{'${spring.kafka.template.default-topic}'}", message);
    }
}
