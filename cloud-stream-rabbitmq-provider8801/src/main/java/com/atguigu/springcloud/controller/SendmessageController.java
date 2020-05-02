package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.ImessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @program: git_springcloud
 * @description:
 * @author: guoxiaobing
 * @create: 2020-05-02 16:54
 */
@RestController
public class SendmessageController {
    @Resource
    private ImessageProvider imessageProvider;
    @GetMapping(value = "/sendMessage")
    public String sendMessage(){
        return imessageProvider.send();
    }
}