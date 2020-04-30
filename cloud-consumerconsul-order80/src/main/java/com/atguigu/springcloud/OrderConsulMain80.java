package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName OrderConsulMain80
 * @Author guoxiaobing
 * @Date 2020/4/23 19:59
 * @Version 1.0
 * @Description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderConsulMain80.class,args);
    }
}
/**
 *
 * CAP
 * C 一致性
 * A 可用性
 * P 分期容错性
 */
