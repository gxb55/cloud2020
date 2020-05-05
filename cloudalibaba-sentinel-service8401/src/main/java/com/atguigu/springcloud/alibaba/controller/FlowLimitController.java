package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.sun.deploy.security.BlockedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @program: git_springcloud
 * @description:
 * @author: guoxiaobing
 * @create: 2020-05-04 20:48
 */
@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping(value = "/testA")
    public String testA() throws InterruptedException {
        log.info(Thread.currentThread().getName()+"..........testA");
        return "--------------testA";
    }
    @GetMapping(value = "/testB")
    public String testB(){
        log.info(Thread.currentThread().getName()+"..........testB");
        return "--------------testB";
    }

    /**
     * 一秒至少5个请求 且一个请求的处理时间大于设置的RT毫秒级别的
     * @return
     */
    @GetMapping(value = "/testD")
    public String testD() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        log.info(Thread.currentThread().getName()+"..熔断测试RT........testD");
        return "--------------testD";
    }

    /**
     * 每秒至少5个请求 且    错误率小于20%
     * @return
     */

    @GetMapping(value = "/testE")
    public String testE()  {
        int i=10/0;
        log.info(Thread.currentThread().getName()+"..异常比例........testD");
        return "--------------testE";
    }


    @GetMapping(value = "/testF")
    public String testF()  {
        int i=10/0;
        log.info(Thread.currentThread().getName()+"..异常数........testF");
        return "--------------testE";
    }


    @GetMapping(value = "/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotkey")  //唯一标识
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2
                             )  {

        log.info(Thread.currentThread().getName()+"..........testHotKey");
        return "p1"+p1+"---p2-"+p2+"----------testHotKey";
    }

    public String deal_testHotkey(String p1, String p2, BlockException excep){
        log.info("p1 {},p2 {},p3{}",p1,p2,excep);
        return  "--------------deal_testHotkey";
    }
}