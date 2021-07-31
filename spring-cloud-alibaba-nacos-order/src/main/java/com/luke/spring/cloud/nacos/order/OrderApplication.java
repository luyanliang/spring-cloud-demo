package com.luke.spring.cloud.nacos.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * functional describe:
 *
 * @author luyanliang [765673481@qq.com]
 * @version 1.0 2021-07-31 10:25
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }
}
