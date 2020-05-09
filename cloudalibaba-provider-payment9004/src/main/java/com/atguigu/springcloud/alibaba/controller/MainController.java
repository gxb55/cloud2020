package com.atguigu.springcloud.alibaba.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MainController
 * @Author guoxiaobing
 * @Date 2020/5/7 19:04
 * @Version 1.0
 * @Description TODO
 */
@RestController
public class MainController {
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/paymentSQL/{id}")
    public CommonResult<Payment> fallback(@PathVariable long id) {
        if(id == 1){
            return new CommonResult(200, "查询成功001,serverPort:" + serverPort+" " +id,new Payment(2020l,"serial001"));
        }else if (id == 2){
            return new CommonResult(200, "查询成功001,serverPort:" + serverPort+" " +id,new Payment(2020l,"serial002"));
        }else if (id == 3){
            return new CommonResult(200, "查询成功001,serverPort:" + serverPort+" " +id,new Payment(2020l,"serial003"));
        }else {
            return new CommonResult(200, "查询成功001,serverPort:" + serverPort+" " +id);
        }
    }
}
