package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @ClassName GateWayMain9527
 * @Author guoxiaobing
 * @Date 2020/4/30 17:32
 * @Version 1.0
 * @Description TODO
 */
@SpringBootApplication
@EnableEurekaClient
public class GateWayMain9527 {
    public static void main(String[] args) {
        SpringApplication.run(GateWayMain9527.class,args);
    }
}
/**
 * 1.curl http://127.0.0.1:9527/payment/lb
 * 2.curl http://127.0.0.1:9527/payment/lb --cookie "username=zzyy"
 * curl http://127.0.0.1:9527/payment/lb  -H "X-Request-Id:-1"
 *
 *
 * predicates
 *
 *
 * gateway是网管 在客户端的请求到到真正提供服务的微服务时候提供了一个屏障
 * 保护了请求 分为三大部分
 * 1.路由 决定了请求要到哪里去
 * 2.断言 返回true和false 决定是否请求能够接着向下执行
 * 3.过滤器 在断言前后配置 做断言前后添加过滤器在过滤器经过过滤 断言为true的时候才会处理服务
 * 可以分为全部过滤器和 单个过滤器
 * 断言 和过滤器都可以使用gateway自定义的来做 当然用的最多的还是我们自定义的过滤器
 * 就是配置config后implement实现两个接口分别是 ordered 以及 globalFilter GlobalFilter
 *
 */