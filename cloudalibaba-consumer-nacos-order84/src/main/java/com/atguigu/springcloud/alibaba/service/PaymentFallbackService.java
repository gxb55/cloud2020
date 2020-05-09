package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @ClassName PaymentFallbackService
 * @Author guoxiaobing
 * @Date 2020/5/7 19:43
 * @Version 1.0
 * @Description TODO
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> fallback(long id) {
        return new CommonResult(440, "查询失败。,PaymentFallbackService.fallback:" +" id" +id);
    }
}
