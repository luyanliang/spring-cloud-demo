package com.luke.spring.cloud.nacos.order.client.feign;

import com.luke.spring.cloud.nacos.order.client.dto.OrderDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author LuYanLiang [lu_yanliang@leapmotor.com]
 * @since 2021/8/5 20:25
 */
@FeignClient(value = "demo-order")
public interface OrderFeign {

    /**
     * 查询订单详细信息
     *
     * @param id 订单ID
     * @return 订单详情
     */
    @GetMapping("order/{id}")
    OrderDto orderInfo(@PathVariable("id") Integer id);
}
