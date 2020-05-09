package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.service.PaymentService;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName CircleBreakerController
 * @Author guoxiaobing
 * @Date 2020/5/7 17:56
 * @Version 1.0
 * @Description TODO
 */
@RestController
public class CircleBreakerController {
    /**
     * blockHandler = "blockHandlerFallback",fallback = "handlerFallback"
     *
     * blockHandler 处理 sentinel中的降级 限流 兜底
     * handlerFallback 出错的时候都找他 兜底
     * 如果两个都配置则系统报错的时候走handlerFallback，超过流控的则走 blockHandler
     *
     *
     */
    public static final String SERVICE_URL = "http://nacos-payment-provider";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/fallback/{id}")
   // @SentinelResource(value = "fallback")
   // @SentinelResource(value = "fallback",fallback = "handlerFallback")//fallback 只处理异常信息
  //  @SentinelResource(value = "fallback",blockHandler = "blockHandlerFallback")//fallback 只处理异常信息
    @SentinelResource(value = "fallback",blockHandler = "blockHandlerFallback",fallback = "handlerFallback"
    ,exceptionsToIgnore = {IllegalArgumentException.class})//fallback 只处理异常信息
    public CommonResult<Payment> fallback(@PathVariable long id) {
        CommonResult<Payment> result = restTemplate.getForObject(SERVICE_URL + "/paymentSQL/" + id, CommonResult.class, id);
        if (id == 4) {
            throw new IllegalArgumentException("IllegalArgumentException,非法参数异常。。。");
        } else if (result.getData() == null) {
            throw new NullPointerException("NullPointerException 改id没有对应的记录，空指针异常");
        }
        return result;
    }

    /**
     * 处理异常的方法
     * @param id
     * @param t
     * @return
     */
    public CommonResult<Payment> handlerFallback(@PathVariable long id,Throwable t){
        return new CommonResult(4444, " handlerFallback异常的统一处理方法,id:" +id+"  Throwable"+t.getMessage());
    }

    public   CommonResult<Payment> blockHandlerFallback (@PathVariable long id, BlockException t){
        return new CommonResult(4444, " blockHandlerFallback违背了sentienl规则的处理方法,id:" +id+"  Throwable"+t.getMessage());
    }

    //////////////////////////////// openfeign
    @Autowired
    private PaymentService paymentService;
    @GetMapping("/consumer/paymentSQL/{id}")
    public CommonResult<Payment> paymentSQL(@PathVariable long id) {
        return paymentService.fallback(id);
    }

}
