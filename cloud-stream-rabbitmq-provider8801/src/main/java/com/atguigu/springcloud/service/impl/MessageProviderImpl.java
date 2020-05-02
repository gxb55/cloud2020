package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.service.ImessageProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @program: git_springcloud
 * @description: 实现类
 * @author: guoxiaobing
 * @create: 2020-05-02 16:45
 */
@EnableBinding(Source.class) //定义消息的推送管道
public class MessageProviderImpl implements ImessageProvider {
    @Resource
    private MessageChannel output;//消息发送管道
    @Override
    public String send() {
        String id = UUID.randomUUID().toString();
        output.send(MessageBuilder.withPayload(id).build());
        System.out.println("************"+id);
        return null;
    }
    /**
     * cloud stream ：
     * 1.binder 链接的中间件屏蔽差异
     * 2.channel 管道
     * 3. source sink 生产者消费者
     */
}