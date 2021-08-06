package com.luke.spring.cloud.nacos.user.controller;

import com.luke.spring.cloud.nacos.order.client.dto.OrderDto;
import com.luke.spring.cloud.nacos.order.client.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author LuYanLiang [lu_yanliang@leapmotor.com]
 * @since 2021/8/6 13:59
 */
@RestController
public class UserController {

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("user/order/{id}")
    public OrderDto findUserOrder(@PathVariable("id") Integer id) {
        return orderFeign.orderInfo(1);
    }
}
