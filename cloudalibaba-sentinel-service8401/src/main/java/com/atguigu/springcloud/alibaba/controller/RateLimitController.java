package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.myhandler.CustomerBlockHandler;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName RateLimitController
 * @Author guoxiaobing
 * @Date 2020/5/6 19:24
 * @Version 1.0
 * @Description TODO
 */
@RestController
@Slf4j
public class RateLimitController {

    @GetMapping("/byResource")
    @SentinelResource(value = "byResource",blockHandler = "handlerException")
    public CommonResult byResource(){
        return new CommonResult(200,"按资源名称限流测试ok",new Payment(2020l,"serial001"));
    }

    public CommonResult handlerException(BlockException exption){
        return new CommonResult(444,exption.getClass().getName()+"服务不可用。。");
    }

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl(){
        return new CommonResult(200,"按照url限流测试ok",new Payment(2020l,"serial002"));
    }


    @GetMapping("/rateLimit/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",
                        blockHandlerClass = CustomerBlockHandler.class,
                        blockHandler ="customerBlockHandler2" )
    public CommonResult customerBlockHandler(){
        return new CommonResult(200,"自定义报错设置",new Payment(2020l,"serial003"));
    }
}
