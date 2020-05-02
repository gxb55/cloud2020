package com.atguigu.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @program: git_springcloud
 * @description: gateway 配置
 * @author: guoxiaobing
 * @create: 2020-05-01 16:00
 */
@Configuration
public class GateWayConfig {
    /**
     * 配置了一个id为path_route_atguigu的路由
     * 当访问地址是http://127.0.0.1:9527/guonei的时候会转发到
     * 地址https://news.baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customerRouteLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu",
                x->x.path("/guonei")
                        .uri("https://news.baidu.com/guonei")).build();

        return routes.build();
    }
    @Bean
    public RouteLocator customerRotelocator1 (RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_atguigu1",x->x.path("/game").uri("https://news.baidu.com/game")).build();
        return routes.build();

    }
}