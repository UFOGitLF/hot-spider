package com.hacker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 启动类
 * Created by Lenovo on 2017/6/27.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude = MongoAutoConfiguration.class)
public class HackerApplication extends SpringBootServletInitializer{
    public static void main(String[] args) {
        SpringApplication.run(HackerApplication.class);
    }

    /**
     * javaEE应用服务器配置
     * 如果要试用tomcat来加载JSP的话就必须继承springBootServletInitializerl类
     * 来重写configure方法
     * @param builder
     * @return
     */
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(HackerApplication.class);
    }
}
