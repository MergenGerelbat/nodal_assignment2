package com.nodalx.service1;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @Scheduled(fixedDelay = 20000) // every 20s
    public void sendPing() {
        String message = "ping from Service 1";
        System.out.println("Service 1 sending: " + message);
        rabbitTemplate.convertAndSend("ping-pong-exchange", "ping.key", message);
    }
}