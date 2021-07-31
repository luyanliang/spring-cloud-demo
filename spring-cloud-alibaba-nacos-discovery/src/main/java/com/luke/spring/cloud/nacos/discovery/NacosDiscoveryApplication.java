package com.luke.spring.cloud.nacos.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * functional describe:
 *
 * @author luyanliang [765673481@qq.com]
 * @version 1.0 2021-07-30 22:20
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(NacosDiscoveryApplication.class, args);
    }
}
