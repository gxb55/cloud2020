package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName ConsumerMain84
 * @Author guoxiaobing
 * @Date 2020/5/7 17:54
 * @Version 1.0
 * @Description TODO
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class ConsumerMain84 {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerMain84.class,args);
    }
}
