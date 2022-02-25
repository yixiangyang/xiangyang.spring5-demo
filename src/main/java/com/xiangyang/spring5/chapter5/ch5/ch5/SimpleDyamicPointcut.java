package com.xiangyang.spring5.chapter5.ch5.ch5;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.DynamicMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * 使用 DynamicMethodMatcherPointcut 创建动态切入点
 * @Author yixiangyang
 * @Date 2022/2/25 17:42
 */
public class SimpleDyamicPointcut extends DynamicMethodMatcherPointcut {
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        System.out.println("Static check for" + method.getName());
        return ("foo".equals(method.getName()));
    }

    @Override
    public boolean matches(Method method, Class<?> cls, Object... args){
        System.out.println("Dynamic check for "+ method.getName());
        int x = ((Integer)args[0]).intValue();
        return (x!=100);
    }

    @Override
    public ClassFilter getClassFilter(){
        return cls->(cls == SampleBean.class);
    }
}
