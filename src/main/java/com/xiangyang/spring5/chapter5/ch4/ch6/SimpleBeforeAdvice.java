package com.xiangyang.spring5.chapter5.ch4.ch6;

import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * 前置通知
 * @Author yixiangyang
 * @Date 2022/2/22 16:13
 */
public class SimpleBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("before "+method.getName()+"   "+objects.toString() +"      "+o.toString());
    }

    public static void main(String[] args) {
        Guitarist johnMayer= new Guitarist();
        ProxyFactory pf = new ProxyFactory();
        pf.addAdvice(new SimpleBeforeAdvice());
        pf.setTarget(johnMayer);

        Guitarist poxy = (Guitarist) pf.getProxy();
        poxy.sing();
    }
}
