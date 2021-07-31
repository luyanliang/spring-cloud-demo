package com.luke.spring.cloud.nacos.order.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * functional describe:
 *
 * @author luyanliang [765673481@qq.com]
 * @version 1.0 2021-07-31 10:46
 */
@Configuration
public class RestConfig {

    /**
     * 实例化 RestTemplate 实例
     */
    @LoadBalanced
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
