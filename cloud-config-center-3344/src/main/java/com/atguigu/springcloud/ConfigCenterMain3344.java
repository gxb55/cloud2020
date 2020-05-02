package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @program: git_springcloud
 * @description: 主启动类
 * @author: guoxiaobing
 * @create: 2020-05-01 20:40
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigCenterMain3344 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigCenterMain3344.class,args);
        /**
         * application 前缀
         * label 分支不写默认master
         * profile 环境后缀 比如 dev
         *
         *
         * /{application}/{profile}[/{label}] http://127.0.0.1:3344/config/dev/master
         * /{application}-{profile}.yml  http://127.0.0.1:3344/config-dev.yml 默认master
         * /{label}/{application}-{profile}.yml   http://127.0.0.1:3344/master/config-dev.yml 指定分支
         * /{application}-{profile}.properties http://127.0.0.1:3344/config-dev.yml 默认master
         * /{label}/{application}-{profile}.properties

         * config配置的常用类型
         * 1./ http://127.0.0.1:3344/master/config-dev.yml
         *
         * 手动发送post请求刷新 curl -X POST "http://127.0.0.1:3355/actuator/refresh"
         *
         *
         * 配置中心成为集群后config分为server和client 3344为server 3355 3366位client
         * 更新git配置后手动发送post到3344 然后3344 同步信息到3355 3366 只用的是rabbitMQ
         *
         * curl -X POST "http://127.0.0.1:3344/actuator/bus-refresh"  全局的通知
         *
         * curl -X POST "http://127.0.0.1:3344/actuator/bus-refresh/config-client:3355"  只通知3355
         *
         * config-client:3355  服务名称 + 端口号
         */
    }
}