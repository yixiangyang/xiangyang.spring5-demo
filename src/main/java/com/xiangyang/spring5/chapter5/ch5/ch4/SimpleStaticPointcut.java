package com.xiangyang.spring5.chapter5.ch5.ch4;

import org.springframework.aop.ClassFilter;
import org.springframework.aop.support.StaticMethodMatcherPointcut;

import java.lang.reflect.Method;

/**
 * @Author yixiangyang
 * @Date 2022/2/25 17:07
 */
public class SimpleStaticPointcut extends StaticMethodMatcherPointcut {
    /**
     * 如果方法返回名是sing 返回true 否则 返回false
     * @param method
     * @param aClass
     * @return
     */
    @Override
    public boolean matches(Method method, Class<?> aClass) {
        return ("sing".equals(method.getName()));
    }

    @Override
    public ClassFilter getClassFilter(){
        return aClass -> (aClass == GoodGuitarist.class);
    }
}
