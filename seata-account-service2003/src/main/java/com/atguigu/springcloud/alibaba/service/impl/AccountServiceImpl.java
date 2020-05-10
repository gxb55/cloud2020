package com.atguigu.springcloud.alibaba.service.impl;

import com.atguigu.springcloud.alibaba.dao.AccountDao;
import com.atguigu.springcloud.alibaba.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * @program: git_springcloud
 * @description:
 * @author: guoxiaobing
 * @create: 2020-05-10 19:27
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;
    @Override
    public void decrease(Long userId, BigDecimal money) {
        log.info("----------->decrease 扣减账户余额开始");
        //模拟食物超时
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (Exception e) {

            System.out.println(e);
        } finally {

        }
        accountDao.decrease( userId,  money);
        log.info("----------->decrease 扣减账户余额结束");

    }
}