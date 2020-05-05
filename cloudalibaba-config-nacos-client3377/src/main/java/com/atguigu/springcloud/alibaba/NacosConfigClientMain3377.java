package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @program: git_springcloud
 * @description:
 * @author: guoxiaobing
 * @create: 2020-05-03 16:29
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientMain3377 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientMain3377.class,args);
        /**
         * ${prefix}-${spring.profile.active}.${file-extension}
         * prefix 应用名称
         * spring.profile.active 配置文件中配置的当前环境
         * file-extension 文件的类型 yaml properties
         *
         * prefix 默认为 spring.application.name 的值，也可以通过配置项 spring.cloud.nacos.config.prefix来配置。
         * spring.profile.active 即为当前环境对应的 profile，详情可以参考 Spring Boot文档。 注意：当 spring.profile.active 为空时，对应的连接符 - 也将不存在，dataId 的拼接格式变成 ${prefix}.${file-extension}
         * file-exetension 为配置内容的数据格式，可以通过配置项 spring.cloud.nacos.config.file-extension 来配置。目前只支持 properties 和 yaml 类型。
         *
         *
         *
         * nacos-config-client-dev.yml
         */
    }
}