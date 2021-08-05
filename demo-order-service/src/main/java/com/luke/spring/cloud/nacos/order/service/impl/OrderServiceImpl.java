package com.luke.spring.cloud.nacos.order.service.impl;

import com.luke.spring.cloud.nacos.order.entity.OrderEntity;
import com.luke.spring.cloud.nacos.order.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * @author LuYanLiang [lu_yanliang@leapmotor.com]
 * @since 2021/8/5 20:14
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public OrderEntity findById(Integer id) {
        OrderEntity entity = new OrderEntity();
        entity.setOrderId(1);
        entity.setOrderNo("23329923");
        entity.setProductId(23L);
        entity.setProductName("水杯");
        entity.setUserId(11687L);
        entity.setUserName("Luke");
        return entity;
    }
}
