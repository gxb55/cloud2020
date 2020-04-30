package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName FeignConfig
 * @Author guoxiaobing
 * @Date 2020/4/27 17:50
 * @Version 1.0
 * @Description 打印日志 首先设置config 然后再yml文件中指定service要使用的log级别是 debug
 */
@Configuration
public class FeignConfig {
    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
