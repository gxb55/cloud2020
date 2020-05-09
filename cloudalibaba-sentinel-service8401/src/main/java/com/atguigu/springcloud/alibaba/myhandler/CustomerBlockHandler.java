package com.atguigu.springcloud.alibaba.myhandler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;

/**
 * @ClassName CustomerBlockHandler
 * @Author guoxiaobing
 * @Date 2020/5/6 19:42
 * @Version 1.0
 * @Description TODO
 */
public class CustomerBlockHandler {


    public static CommonResult customerBlockHandler1(BlockException e) {
        return new CommonResult(4444, "自定义报错-------------1");

    }
        public static CommonResult customerBlockHandler2(BlockException e){
            return new CommonResult(4444,"自定义报错-------------2");
        }
}
