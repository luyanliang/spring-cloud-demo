package com.luke.spring.cloud.nacos.config.controller;

import com.luke.spring.cloud.nacos.config.domain.LevelStatusList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * functional describe:
 *
 * @author luyanliang [765673481@qq.com]
 * @version 1.0 2021-07-31 14:44
 */
@RestController
@RefreshScope   // 替换配置Bean
public class HelloWorldController {

    @Value("${project.domain}")
    private String name;
    @Autowired
    private LevelStatusList levelStatusList;

    @GetMapping("test/value")
    public String testValue() {
        List<Map<String, String>> mapList = levelStatusList.getList();
        System.out.println(mapList);
        return name;
    }
}
