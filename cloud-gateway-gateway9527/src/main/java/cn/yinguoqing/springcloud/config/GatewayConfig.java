package cn.yinguoqing.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Yin Guoqing
 * @date 2022/10/17
 */
@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("id1", r -> r.path("/guonei").uri("https://news.baidu.com/guonei"))
                .route("id2", r -> r.path("/guoji").uri("https://www.bilibili.com/guoji"))
                .build();
    }
}