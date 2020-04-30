package com.atguigu.springcloud;

import com.atguigu.myrule.MySelfRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @program: cloud2020
 * @description: 启动类
 * @author: guoxiaobing
 * @create: 2020-04-15 15:39
 * RibbonClient 自定义轮训算法 name是针对于那个服务 configuration是规则必须在ComponentScan扫不到的地方
 *
 * 负载均衡算法  = rest接口第几次请求 % 服务器集群总数量  = 实际调用服务器位置下标
 * list = 1%2 indes list.get(index)
 * list = 2%2 indes list.get(index)
 * list = 3%2 indes list.get(index)
 */
@SpringBootApplication
@EnableEurekaClient
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class,args);
    }
}
