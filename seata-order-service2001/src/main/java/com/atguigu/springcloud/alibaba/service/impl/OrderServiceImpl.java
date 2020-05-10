package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.OrderDao;
import com.atguigu.springcloud.alibaba.domain.Order;
import com.atguigu.springcloud.alibaba.service.AccountService;
import com.atguigu.springcloud.alibaba.service.OrderService;
import com.atguigu.springcloud.alibaba.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: git_springcloud
 * @description:
 * @author: guoxiaobing
 * @create: 2020-05-10 18:25
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private StorageService storageService;
    @Autowired
    private AccountService accountService;



    @Override
    @GlobalTransactional(name="fsp-create-order",rollbackFor = Exception.class) //全局事务 name要唯一！！
    public void create(Order order) {
        log.info("------------开始新建订单。。。");
        orderDao.create(order);

        log.info("------------订单微服务开始调用库存，做减法。begin。。");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("------------订单微服务开始调用库存，做减法。end。。");

        log.info("------------订单微服务开始调用账户，做减法。begin。。");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("------------订单微服务开始调用账户，做减法。end。。");

        orderDao.update(order.getUserId(),0);

        log.info("------------下订单结束了-------------。。");
    }
}