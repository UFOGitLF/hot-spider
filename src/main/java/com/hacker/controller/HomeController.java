package com.hacker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Description:主页
 */
@Controller
@CrossOrigin
public class HomeController {

    @GetMapping(value = {"/index","/"})
    public String go(){
        return "index";
    }
}
