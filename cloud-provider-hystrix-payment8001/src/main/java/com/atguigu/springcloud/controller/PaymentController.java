package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PaymentController
 * @Author guoxiaobing
 * @Date 2020/4/27 19:39
 * @Version 1.0
 * @Description TODO
 */
@RestController
@Slf4j
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable("id") Integer id){
        log.info("------paymentInfo_ok-------"+id);
        return  paymentService.paymentInfo_ok(id);
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        log.info("--------paymentInfo_TimeOut-----"+id);
        return  paymentService.paymentInfo_TimeOut(id);
    }
    ///---------------------服务熔断

    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuiBreaker(@PathVariable("id") Integer id){
        log.info("--------paymentCircuitBreaker-----"+id);
        return  paymentService.paymentCircuitBreaker(id);
    }
}
