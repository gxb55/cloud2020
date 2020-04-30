package com.atguigu.springcloud.lb;

import org.junit.Test;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName MyLB
 * @Author guoxiaobing
 * @Date 2020/4/26 19:19
 * @Version 1.0
 * @Description TODO
 */
@Component
public class MyLB implements LoadBalancer {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            next = current >= 2000000000 ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("----------------" + next);
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> ServiceInstances) {
        int i = getAndIncrement() % ServiceInstances.size();
        return ServiceInstances.get(i);

    }
}
