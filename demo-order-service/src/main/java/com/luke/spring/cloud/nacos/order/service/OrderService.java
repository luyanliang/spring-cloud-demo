package com.luke.spring.cloud.nacos.order.service;

import com.luke.spring.cloud.nacos.order.entity.OrderEntity;

/**
 * @author LuYanLiang [765673481@qq.com]
 * @since 2021/8/5 20:13
 */
public interface OrderService {

    /**
     * 根据订单ID查询订单信息
     *
     * @param id 订单ID
     * @return 订单详情
     */
    OrderEntity findById(Integer id);
}
