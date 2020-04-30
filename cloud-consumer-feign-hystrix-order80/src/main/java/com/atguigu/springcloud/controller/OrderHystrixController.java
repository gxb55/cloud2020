package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PaymentHystrixController
 * @Author guoxiaobing
 * @Date 2020/4/27 20:08
 * @Version 1.0
 * @Description TODO
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_fallbackMethod")
public class OrderHystrixController {
    @Autowired
    private PaymentHystrixService paymentHystrixService;
    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
     return paymentHystrixService.paymentInfo_ok(id);
    }

    @HystrixCommand/*(fallbackMethod = "paymentInfo_Hystrix_TimeOut",
            commandProperties = {@HystrixProperty( name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")})*/
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        int age =10/0;
        return paymentHystrixService.paymentInfo_TimeOut(id);
    }
    public String paymentInfo_Hystrix_TimeOut(@PathVariable("id") Integer id){
        return "完蛋了服务调不通了";
    }
    //下面是全局 fallback
    public String payment_Global_fallbackMethod(){
        return "payment_Global_fallbackMethod完蛋了服务调不通了";
    }
}
