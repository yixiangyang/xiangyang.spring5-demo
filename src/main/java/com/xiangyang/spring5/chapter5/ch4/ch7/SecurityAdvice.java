package com.xiangyang.spring5.chapter5.ch4.ch7;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;
import java.security.SecureRandom;

/**
 * 使用前置通知 保护方法访问
 * @Author yixiangyang
 * @Date 2022/2/23 14:24
 */
public class SecurityAdvice implements MethodBeforeAdvice {

    private SecurityManager securityManager;

    public SecurityAdvice(){
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo user = securityManager.getLoggedOnUser();
        if(user == null){
            System.out.println("no user authenticated");
            throw new SecurityException("you must login before" +
                    " attempting to invoke the method:"+method.getName());
        }else if("John".equals(user.getUserName())){
            System.out.println("Logged in user is john --okay!");
        }else {
            System.out.println("logged in user is"+user.getUserName()+
                    "not good:");
            throw new SecurityException("user:"+user.getUserName()+
                    "is not allowed access to method" + method.getName());
        }
    }
}
