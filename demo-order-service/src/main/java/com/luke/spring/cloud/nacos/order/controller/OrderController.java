package com.luke.spring.cloud.nacos.order.controller;

import com.luke.spring.cloud.nacos.order.entity.OrderEntity;
import com.luke.spring.cloud.nacos.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * functional describe:
 *
 * @author luyanliang [765673481@qq.com]
 * @version 1.0 2021-07-31 10:26
 */
@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("order/{id}")
    public OrderEntity orderInfo(@PathVariable("id") Integer id) {
        return orderService.findById(id);
    }

}
