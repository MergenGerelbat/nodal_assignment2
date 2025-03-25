package com.nodalx.service1;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE_NAME = "ping-pong-exchange";
    public static final String PING_QUEUE = "ping-queue";
    public static final String PONG_QUEUE = "pong-queue";

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(EXCHANGE_NAME);
    }

    @Bean
    Queue pongQueue() {
        return new Queue(PONG_QUEUE, false);
    }

    @Bean
    Binding pongBinding(Queue pongQueue, TopicExchange exchange) {
        return BindingBuilder.bind(pongQueue).to(exchange).with("pong.key");
    }
}