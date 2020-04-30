package com.atguigu.springcloud;

import com.sun.glass.ui.Application;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName PaymentMain8084
 * @Author guoxiaobing
 * @Date 2020/4/21 19:29
 * @Version 1.0
 * @Description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient //该注解用于向使用consul或者zookeeper作为注册中心时注册服务
public class PaymentMain8084 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8084.class,args);
    }
}
