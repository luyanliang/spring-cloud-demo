package com.luke.spring.cloud.gatway.predicates;

import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.cloud.gateway.handler.predicate.GatewayPredicate;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * functional describe: 自定义路由断言工厂
 * <p>
 * 自定义路由断言工厂需要继承AbstractRoutePredicateFactory类，重写apply方法的逻辑。在apply方法中可以
 * 通过exchange.getRequest()拿到ServerHttpRequest对象，从而可以获取到请求的餐素、请求方式、请求头等信息。
 * <p>
 * NOTE: 命名需要以【RoutePredicateFactory】结尾
 *
 * @author luyanliang [765673481@qq.com]
 * @version 1.0 2021-08-19 21:08
 */
@Component
public class CheckAuthRoutePredicateFactory extends AbstractRoutePredicateFactory<CheckAuthRoutePredicateFactory.Config> {

    public CheckAuthRoutePredicateFactory() {
        super(Config.class);
    }

    @Override
    public Predicate<ServerWebExchange> apply(Config config) {
        return (GatewayPredicate) serverWebExchange -> "luke".equals(config.getName());
    }

    /**
     * 快捷配置
     */
    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("name");
    }

    public static class Config {

        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
