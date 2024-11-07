package com.griddynamics.czechowiczk.rabbitmqproject;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class RabbitPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final String exchange;
    private final String routingKey;

    public RabbitPublisher(RabbitTemplate rabbitTemplate,
        @Value("${rabbitmq.exchange}") String exchange,
        @Value("${rabbitmq.routing-key}") String routingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    @Scheduled(fixedRateString = "${rabbitmq.message-rate:10}")
    public void sendMessage() {
        String message = "Hello RabbitMQ! " + System.currentTimeMillis();
        rabbitTemplate.convertAndSend(exchange, routingKey, message);
        System.out.println("Sent: " + message);
    }
}
