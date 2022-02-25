package com.xiangyang.spring5.chapter5.ch5.ch5;

import com.xiangyang.spring5.chapter5.ch5.ch4.SimpleAdvice;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * @Author yixiangyang
 * @Date 2022/2/25 17:56
 */
public class DynamicPointcutDemo {
    public static void main(String[] args) {
        SampleBean target = new SampleBean();
        Advisor advisor = new DefaultPointcutAdvisor(new SimpleDyamicPointcut(),new SimpleAdvice());

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvisors(advisor);
        SampleBean proxy = (SampleBean) pf.getProxy();
        proxy.foo(1);
        proxy.foo(10);
        proxy.foo(100);

        proxy.bar();

        proxy.bar();

        proxy.bar();

    }
}
