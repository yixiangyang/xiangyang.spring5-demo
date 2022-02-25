package com.xiangyang.spring5.chapter5.ch4.ch10;

import org.springframework.aop.ThrowsAdvice;
import org.springframework.aop.framework.ProxyFactory;

import java.lang.reflect.Method;

/**
 * 创建异常通知
 * Spring 在异常通知中寻找的第一方法是一个或者多个被称为afterThrowing()的公共方法。
 * 方法的返回类型并不重要 但最好是void 因为此方法不能返回任何有意义的值
 * @Author yixiangyang
 * @Date 2022/2/25 16:03
 */
public class SimpleThrowsAdvice implements ThrowsAdvice {

    public static void main(String[] args) {
        ErrorBean errorBean = new ErrorBean();
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(errorBean);
        factory.addAdvice(new SimpleThrowsAdvice());
        ErrorBean proxy = (ErrorBean) factory.getProxy();
        try {
            proxy.errorProneMethod();
        }catch (Exception ignored){

        }

        try {
            proxy.otherErrorProneMethod();
        }catch (Exception ignored){

        }
    }

    public void afterThrowing(Exception ex) throws Throwable{
        System.out.println("***");
        System.out.println("generic exception capture");
        System.out.println("caught :" +ex.getClass().getName());
        System.out.println("***\n");
    }

    public void afterThrowing(Method method,Object args,Object target,IllegalArgumentException ex){
        System.out.println("***");
        System.out.println("IllegalArgumentException capture");
        System.out.println("Caught:" +ex.getClass().getName());
        System.out.println("method:" +method.getName());
        System.out.println("***\n");
    }
}
