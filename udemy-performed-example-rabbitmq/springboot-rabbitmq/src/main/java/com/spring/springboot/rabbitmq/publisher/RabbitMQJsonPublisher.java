package com.spring.springboot.rabbitmq.publisher;

import com.spring.springboot.rabbitmq.dto.User;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQJsonPublisher {

    private static final Logger LOGGER = LoggerFactory.getLogger(RabbitMQJsonPublisher.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.routing.json.key}")
    private String routingJsonKey;

    private RabbitTemplate rabbitTemplate;

    public RabbitMQJsonPublisher(RabbitTemplate rabbitTemplate){
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendJsonMessage(User user){
        LOGGER.info(String.format("Json Message sent -> %s", user.toString()));
        try {
            rabbitTemplate.convertAndSend(exchange, routingJsonKey, user);
        } catch (Exception e){
            LOGGER.info("Error: =============={}", e.getMessage());
        }
    }

}
