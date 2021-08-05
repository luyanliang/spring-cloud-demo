package com.luke.spring.cloud.nacos.order.client.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author LuYanLiang [lu_yanliang@leapmotor.com]
 * @since 2021/8/5 20:24
 */
@Getter
@Setter
public class OrderDto implements Serializable {
    private static final long serialVersionUID = 6216359502485580184L;

    /**
     * 订单ID
     */
    private Integer orderId;

    /**
     * 订单编号
     */
    private String orderNo;

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 商品ID
     */
    private Long productId;

    /**
     * 商品名称
     */
    private String productName;
}
