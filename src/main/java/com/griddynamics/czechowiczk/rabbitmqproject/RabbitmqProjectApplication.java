package com.griddynamics.czechowiczk.rabbitmqproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RabbitmqProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(RabbitmqProjectApplication.class, args);
    }

}
