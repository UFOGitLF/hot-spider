package com.hacker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 主页
 * Created by Lenovo on 2017/6/28.
 */
@Controller
public class HomeController {
    @GetMapping(value = {"/index","/"})
    public String go(){
        return "index";
    }
}
