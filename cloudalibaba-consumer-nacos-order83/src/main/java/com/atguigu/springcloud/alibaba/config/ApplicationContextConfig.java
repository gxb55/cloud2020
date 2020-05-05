package com.atguigu.springcloud.alibaba.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: git_springcloud
 * @description:
 * @author: guoxiaobing
 * @create: 2020-05-03 15:45
 */
@Configuration
public class ApplicationContextConfig {
    @Bean
    @LoadBalanced
    public RestTemplate getTestTemplate(){
        return  new RestTemplate();
    }
}