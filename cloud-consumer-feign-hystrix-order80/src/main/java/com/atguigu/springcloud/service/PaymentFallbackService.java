package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName PaymentFallbackService
 * @Author guoxiaobing
 * @Date 2020/4/29 17:22
 * @Version 1.0
 * @Description TODO
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String paymentInfo_ok(Integer id) {
        return "PaymentFallbackService ------fall back paymentInfo_ok ";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "PaymentFallbackService ------fall back paymentInfo_TimeOut ";
    }
}
