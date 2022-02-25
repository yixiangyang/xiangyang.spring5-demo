package com.xiangyang.spring5.chapter5.ch4.ch9;

import org.springframework.aop.framework.ProxyFactory;

/**
 * 环绕通知
 * @Author yixiangyang
 * @Date 2022/2/25 15:41
 */
public class ProfilingDemo {
    public static void main(String[] args) {
        WorkerBean bean = getWorkerBean();
        bean.doSomeWork(10000000);
    }

    private static WorkerBean getWorkerBean(){
        WorkerBean target = new WorkerBean();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(new ProfilingInterceptor());
        return (WorkerBean) factory.getProxy();
    }
}
