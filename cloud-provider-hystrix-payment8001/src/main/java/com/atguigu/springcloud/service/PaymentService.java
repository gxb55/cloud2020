package com.atguigu.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName PaymentService
 * @Author guoxiaobing
 * @Date 2020/4/27 19:33
 * @Version 1.0
 * @Description TODO
 */
@Service
public class PaymentService {

    /**
     * 正常访问的
     *
     * @param id
     * @return
     */
    public String paymentInfo_ok(Integer id) {
        return "线程池： " + Thread.currentThread().getName() + "paymentInfo_ok,id :" + '\t' + id;
    }
    @HystrixCommand(fallbackMethod ="paymentInfo_TimeOutHandler",
            commandProperties = {@HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")})
    public String paymentInfo_TimeOut(Integer id) {
        //int age =10/0;
        int time = 3;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (Exception e) {

        }
        return "线程池： " + Thread.currentThread().getName() + "paymentInfo_TimeOut,id :" + '\t' + id + " 耗时"+ time+"秒钟";
    }

    public String paymentInfo_TimeOutHandler(Integer id){
        return "线程池： " + Thread.currentThread().getName() + "系统忙稍后再试,id :" + '\t' + id + " 耗时"+11+"秒钟";

    }
    //============================熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",
    commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),//请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),//时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")//失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if(id<0){
            throw  new RuntimeException("id 不能为负数哦"+id);
        }
        String num = IdUtil.simpleUUID();
        return Thread.currentThread().getName()+"调用成功哦了 "+num;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数！！ id:"+id;
    }


}
