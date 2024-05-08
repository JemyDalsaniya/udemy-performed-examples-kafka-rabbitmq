package com.spring.springboot.kafka.example.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {


    @Bean
    public NewTopic inextureTopic(){
        return TopicBuilder.name("wikimedia_recentchange")
                .build();
    }
    @Bean
    public NewTopic inextureTopic_json(){
        return TopicBuilder.name("inexture_json")
                .build();
    }
}
