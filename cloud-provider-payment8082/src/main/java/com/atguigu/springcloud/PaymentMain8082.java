package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @program: cloud2020
 * @description: 启动类
 * @author: guoxiaobing
 * @create: 2020-04-14 19:51
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentMain8082 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8082.class, args);
    }
}