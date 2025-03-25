package com.nodalx.service2

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMQConfig {

    companion object {
        const val EXCHANGE_NAME = "ping-pong-exchange"
        const val PING_QUEUE = "ping-queue"
        const val PONG_QUEUE = "pong-queue"
    }

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(EXCHANGE_NAME)
    }

    @Bean
    fun pingQueue(): Queue {
        return Queue(PING_QUEUE, false)
    }

    @Bean
    fun pingBinding(pingQueue: Queue, exchange: TopicExchange): Binding {
        return BindingBuilder.bind(pingQueue).to(exchange).with("ping.key")
    }
}