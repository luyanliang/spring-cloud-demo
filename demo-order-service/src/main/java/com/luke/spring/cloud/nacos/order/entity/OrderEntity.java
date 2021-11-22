package com.luke.spring.cloud.nacos.order.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author LuYanLiang [765673481@qq.com]
 * @since 2021/8/5 20:08
 */
@Getter
@Setter
public class OrderEntity implements Serializable {
    private static final long serialVersionUID = 3338090049120314452L;

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
