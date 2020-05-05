package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.netflix.eureka.EurekaDiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @program: cloud2020
 * @description:
 * @author: guoxiaobing
 * @create: 2020-04-15 15:45
 */
@Slf4j
@RestController
public class OrderController {
    // public static final String PAYMENT_URL = "http://127.0.0.1:8081";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private LoadBalancer loadBalancer;
    @Autowired
    private EurekaDiscoveryClient eurekaDiscoveryClient;
    @GetMapping(value = "/consumer/payment/lb")
    public Object getPaymentLB() {
        List<ServiceInstance> instances = this.eurekaDiscoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(null == instances || instances.size() == 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return this.restTemplate.getForObject(uri+"/payment/lb",String.class);
    }
    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }


    @GetMapping("/consumer/payment/ForEntity/{id}")
    public CommonResult<Payment> getPayment2(@PathVariable("id") long id) {
        ResponseEntity<CommonResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
          log.info("forEntity--------"+forEntity.getHeaders());
            return forEntity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败！");
        }
    }

    @GetMapping("/consumer/payment/zipKin")
    public String getPayment() {
        List<ServiceInstance> instances = this.eurekaDiscoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(null == instances || instances.size() == 0){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.instances(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri + "/payment/zipKin", String.class);
    }
}
