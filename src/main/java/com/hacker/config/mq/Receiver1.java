package com.hacker.config.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "jd-queue")
public class Receiver1 {

    @RabbitHandler
    public void process(String msg) {
        System.out.println("Receiver1  : " + msg);
    }

}