package com.luke.spring.cloud.nacos.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * functional describe:
 *
 * @author luyanliang [765673481@qq.com]
 * @version 1.0 2021-07-31 14:44
 */
@RestController
@RefreshScope   // 替换配置Bean
public class HelloWorldController {

    @Value("${project.domain}")
    private String name;

    @GetMapping("test/value")
    public String testValue() {
        return name;
    }
}
