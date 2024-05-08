package com.spring.springboot.rabbitmq.consumer;

import com.spring.springboot.rabbitmq.dto.User;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQConsumer {

    private static final Logger LOG = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = {"${rabbitmq.queue.name}"})
    public void consume(String message) {
        LOG.info(String.format("Received RabbitMQ message: %s", message));
    }

    @RabbitListener(queues = {"${rabbitmq.json.queue.name}"})
    public void consumeJson(User user) {
        LOG.info(String.format("Received JSON RabbitMQ message: %s", user.toString()));
    }
}
