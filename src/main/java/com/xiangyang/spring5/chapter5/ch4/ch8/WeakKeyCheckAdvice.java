package com.xiangyang.spring5.chapter5.ch4.ch8;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

import static com.xiangyang.spring5.chapter5.ch4.ch8.KeyGenerator.WEAK_KEY;

/**
 * 检查getKey()方法的结果是否是弱密钥
 * @Author yixiangyang
 * @Date 2022/2/25 15:17
 */
public class WeakKeyCheckAdvice implements AfterReturningAdvice {
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        if((target instanceof KeyGenerator) && ("getKey".equals(method.getName()))){
            long key = ((Long)returnValue).longValue();
            if(key == WEAK_KEY){
                throw new SecurityException("key generator generated a weak key .try again");
            }
        }
    }
}
