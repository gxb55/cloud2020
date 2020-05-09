package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @ClassName PaymentService
 * @Author guoxiaobing
 * @Date 2020/5/7 19:39
 * @Version 1.0
 * @Description TODO
 */
@FeignClient(value = "nacos-payment-provider",fallback = PaymentFallbackService.class)
public interface PaymentService {
     @GetMapping("/paymentSQL/{id}")
     CommonResult<Payment> fallback(@PathVariable("id") long id);
}
