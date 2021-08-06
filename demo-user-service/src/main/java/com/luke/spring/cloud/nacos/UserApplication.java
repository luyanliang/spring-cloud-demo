package com.luke.spring.cloud.nacos;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author LuYanLiang [lu_yanliang@leapmotor.com]
 * @since 2021/8/6 13:52
 */
@SpringCloudApplication
@EnableFeignClients
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }
}
