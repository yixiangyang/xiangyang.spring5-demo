package com.xiangyang.spring5.chapter5.ch5.ch4;

import com.xiangyang.spring5.chapter5.ch4.ch6.Singer;
import org.aopalliance.aop.Advice;
import org.springframework.aop.Advisor;
import org.springframework.aop.Pointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;

/**
 * 使用 StaticMethodMatcherPointcut创建静态切入点
*@Author yixiangyang
*@Date 2022/2/25 17:14
*/
public class StaticPointcutDemo {
    public static void main(String[] args) {
        GoodGuitarist johnMayer = new GoodGuitarist();
        GreatGuitarist ericClapton = new GreatGuitarist();
        Singer proxyOne;
        Singer proxyTwo;
        Pointcut pc = new SimpleStaticPointcut();
        Advice advice = new SimpleAdvice();
        Advisor advisor = new DefaultPointcutAdvisor(pc,advice);
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvisors(advisor);
        pf.setTarget(johnMayer);
        proxyOne = (Singer) pf.getProxy();
        pf = new ProxyFactory();
        pf.addAdvisors(advisor);
        pf.setTarget(ericClapton);
        proxyTwo = (Singer) pf.getProxy();
        proxyOne.sing();
        proxyTwo.sing();
    }
}
