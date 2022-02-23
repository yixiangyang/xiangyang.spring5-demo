package com.xiangyang.spring5.chapter5.ch3;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 实现环绕通知
 * 在调用方法之前以及之后返回执行的相关操作
 * @Author yixiangyang
 * @Date 2022/2/21 17:42
 */
public class AgentDecorator implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("James");
        Object retVal = methodInvocation.proceed();
        System.out.println("!");
        return retVal;
    }
}
