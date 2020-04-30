package com.atguigu.springcloud.contrller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @ClassName OrderZKController
 * @Author guoxiaobing
 * @Date 2020/4/21 20:13
 * @Version 1.0
 * @Description TODO
 */
@RestController
@Slf4j
public class OrderZKController {
    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    public RestTemplate restTemplate;
    @GetMapping(value = "/consumer/payment/zk")
    public String  paymentInfo(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        return result;
    }

    @GetMapping(value = "/consumer/payment/zk1")
    public String  paymentInfo1(){
        String result = restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
        return result;
    }
}
