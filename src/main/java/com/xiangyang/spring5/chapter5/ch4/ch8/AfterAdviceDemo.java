package com.xiangyang.spring5.chapter5.ch4.ch8;

import org.springframework.aop.framework.ProxyFactory;

/**
 * 创建后置返回通知
 * @Author yixiangyang
 * @Date 2022/2/25 15:21
 */
public class AfterAdviceDemo {
    private static KeyGenerator getKeyGenerator(){
        KeyGenerator target = new KeyGenerator();
        ProxyFactory factory = new ProxyFactory();
        factory.addAdvice(new WeakKeyCheckAdvice());
        factory.setTarget(target);
        return (KeyGenerator) factory.getProxy();
    }

    public static void main(String[] args) {
        KeyGenerator keyGen = getKeyGenerator();
        for (int x = 0;x<10;x++){
            try {
                long key = keyGen.getKey();
                System.out.println("Key: "+key);
            }catch (SecurityException ex){
                System.out.println("Weak key generated!");
            }
        }
    }

}
