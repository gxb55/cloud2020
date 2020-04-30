package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @program: cloud2020
 * @description: //@Repository
 * @author: guoxiaobing
 * @create: 2020-04-14 20:12
 */

@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public  Payment getPaymentById(@Param("id") Long id);
}