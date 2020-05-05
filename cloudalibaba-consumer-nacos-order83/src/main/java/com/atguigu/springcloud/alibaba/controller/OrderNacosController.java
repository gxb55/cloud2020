package com.atguigu.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @program: git_springcloud
 * @description:
 * @author: guoxiaobing
 * @create: 2020-05-03 15:47
 */
@RestController
@Slf4j
public class OrderNacosController {
    public static final String PAYMENT_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate template;
    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping(value = "/consumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id")Integer id){
        return template.getForObject(serverURL+"/payment/nacos/"+id,String.class);
    }
}