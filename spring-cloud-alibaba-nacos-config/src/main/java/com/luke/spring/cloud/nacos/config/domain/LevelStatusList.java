package com.luke.spring.cloud.nacos.config.domain;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author LuYanLiang [lu_yanliang@leapmotor.com]
 * @since 2021/11/6 9:53
 */
@Configuration
@ConfigurationProperties("level")
@RefreshScope
public class LevelStatusList {

    private List<Map<String, String>> list;

    public List<Map<String, String>> getList() {
        return list;
    }

    public void setList(List<Map<String, String>> list) {
        this.list = list;
    }
}
