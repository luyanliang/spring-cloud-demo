package com.luke.spring.cloud.oauth2.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * functional describe:
 *
 * @author luyanliang [765673481@qq.com]
 * @version 1.0 2022-03-11 22:05
 */
@RestController
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/{id}")
    public Object getCurrentUserInfo(@PathVariable String id) {
        return "order id : " + id;
    }
}
