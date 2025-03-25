package com.nodalx.service1;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {

    @RabbitListener(queues = "pong-queue")
    public void receiveMessage(String message) {
        System.out.println("Service 1 received: " + message);
    }
}