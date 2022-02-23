package com.xiangyang.spring5.chapter5.ch3;

import org.springframework.aop.framework.ProxyFactory;

/**
 * @Author yixiangyang
 * @Date 2022/2/21 17:47
 */
public class AgentAopDemo {
    public static void main(String[] args) {
        Agent target = new Agent();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new AgentDecorator());
        pf.setTarget(target);
        Agent proxy = (Agent) pf.getProxy();
        target.spack();
        System.out.println("   ----------    ");
        proxy.spack();
    }
}
