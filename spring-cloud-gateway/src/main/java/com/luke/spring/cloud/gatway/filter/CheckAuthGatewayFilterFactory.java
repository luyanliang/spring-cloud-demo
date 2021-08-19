package com.luke.spring.cloud.gatway.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractNameValueGatewayFilterFactory;
import org.springframework.stereotype.Component;

/**
 * functional describe: 自定义过滤器工厂
 * <p>
 * 继承AbstractNameValueGatewayFilterFactory且我们的自定义名称必须要以GatewayFilterFactory
 * 结尾并交给Spring管理
 *
 * @author luyanliang [765673481@qq.com]
 * @version 1.0 2021-08-19 21:49
 */
@Component
@Slf4j
public class CheckAuthGatewayFilterFactory extends AbstractNameValueGatewayFilterFactory {

    @Override
    public GatewayFilter apply(NameValueConfig config) {
        return (exchange, chain) -> {
            log.info("调用CheckAuthGatewayFilterFactory==="
                    + config.getName() + ":" + config.getValue());
            return chain.filter(exchange);
        };
    }
}
