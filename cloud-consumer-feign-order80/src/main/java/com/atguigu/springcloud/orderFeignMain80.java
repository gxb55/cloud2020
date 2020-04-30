package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @ClassName orderFeignMain80
 * @Author guoxiaobing
 * @Date 2020/4/26 19:54
 * @Version 1.0
 * @Description TODO
 */
@SpringBootApplication
@EnableFeignClients
public class orderFeignMain80 {
    public static void main(String[] args) {
        SpringApplication.run(orderFeignMain80.class,args);
    }
}

