package com.luke.spring.cloud.nacos.discovery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * functional describe:
 *
 * @author luyanliang [765673481@qq.com]
 * @version 1.0 2021-07-31 09:54
 */
@RestController
public class HelloWorldController {

    @GetMapping("/index")
    public String helloWold() {
        return "hello world";
    }

    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        return "Hello Nacos Discovery " + string;
    }
}
