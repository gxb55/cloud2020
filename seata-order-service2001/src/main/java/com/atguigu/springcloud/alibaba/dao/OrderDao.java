package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderDao {
    /**
     * 1.新建订单
     * 2.修改订单状态
     */

    void create(Order order);

    void update (@Param("userId") Long userId,@Param("status") Integer status);
}
