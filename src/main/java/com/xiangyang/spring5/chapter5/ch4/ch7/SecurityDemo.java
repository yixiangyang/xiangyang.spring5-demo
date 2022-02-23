package com.xiangyang.spring5.chapter5.ch4.ch7;

import org.springframework.aop.framework.ProxyFactory;

/**
 * 前置通知测试
 * @Author yixiangyang
 * @Date 2022/2/23 14:34
 */
public class SecurityDemo {
    public static void main(String[] args) {
        SecurityManager mgr = new SecurityManager();
        SecureBean bean = getSecureBean();
        mgr.login("John","pwd");
        bean.writeSecureMessage();
        try {
            mgr.login("invalid user","pwd");
            bean.writeSecureMessage();
        }catch (SecurityException ex){
            System.out.println("Exception caught: "+ex.getMessage());
        }finally {
            mgr.logout();
        }

        try {
            bean.writeSecureMessage();
        }catch (SecurityException ex){
            System.out.println("exception caught:"+ex.getMessage());
        }
    }

    private static SecureBean getSecureBean(){
        SecureBean target = new SecureBean();
        SecurityAdvice advice = new SecurityAdvice();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(target);
        factory.addAdvice(advice);
        SecureBean proxy = (SecureBean) factory.getProxy();
        return proxy;
    }
}
