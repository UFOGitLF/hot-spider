package com.hacker.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import javax.annotation.Resource;

/**
 * Description:主页
 */
@Controller
@CrossOrigin
public class HomeController {

    @Resource
    private AmqpTemplate rabbitTemplate;

    @GetMapping(value = {"/index","/"})
    public String go(){
        rabbitTemplate.convertAndSend("jd-queue","I love RabbitMQ!!!!!");
        return "index";
    }
}
